package com.example.devoir3;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;

import android.os.AsyncTask;


import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;
public class NotificationPage extends AppCompatActivity {
    RecyclerView rv;
    Button readNotifBtn;
    ImageView ivNotificationPageProfil;
    ImageView ivToutesNotifParametres;
    BottomNavigationView bottomNavigationMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_page);
        // Creation du on click pour le bouton qui affiche que les notifications non lues
        readNotifBtn = findViewById(R.id.toutesNotifications);
        readNotifBtn.setOnClickListener(e->{
            Intent intent = new Intent(NotificationPage.this,NotificationsNonLues.class);
            startActivity(intent);
        });
        setOnclickNavBar();
        //  Ajoute des séparateurs d'items pour le recycler view
        rv = findViewById(R.id.recycler_view);
        rv.addItemDecoration(new DividerItemDecoration(NotificationPage.this, DividerItemDecoration.VERTICAL));
        // Exécute la tâche asynchrone
        MyTask task = new MyTask();
        task.execute();
        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        ivNotificationPageProfil = (ImageView) findViewById(R.id.ivNotificationPageProfil);
        ivNotificationPageProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationPage.this, MonProfil.class);
                startActivity(intent);
            }
        });
        //Lorsque l'utilisateur clique sur l'icône paramètres, il est ramené vers la page « ParametresNotification »
        ivToutesNotifParametres = (ImageView) findViewById(R.id.ivToutesNotifParametres);
        ivToutesNotifParametres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationPage.this, ParametresNotification.class);
                startActivity(intent);
            }
        });
    }
    //Methode pour initialiser les fonctionnement de la barre de navigation
    public void setOnclickNavBar(){
        bottomNavigationMenu=findViewById(R.id.barnavigationNotifs);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.mescours){
                Intent intent=new Intent(NotificationPage.this, MesCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.search){
                Intent intent=new Intent(NotificationPage.this,RechercherCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.calendrier){
                Intent intent=new Intent(NotificationPage.this,CalendarActivity.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.message){
                Intent intent=new Intent(NotificationPage.this,Messagerie.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
    // Définis une tâche asynchrone.
    class MyTask extends AsyncTask<Void, Void, Notification>{
        @Override
        protected Notification doInBackground(Void... voids) {
            Notification notifs = new Notification();
            return notifs;
        }
        @Override
        protected void onPostExecute(Notification notifs) {
            super.onPostExecute(notifs);
            MyAdapter adapter = new MyAdapter(notifs.notifications);
            rv.setAdapter(adapter);
        }
    }
   //Adapter pour le recycler view
    class MyAdapter extends RecyclerView.Adapter<MyHolder>{
        List notifs;
        MyAdapter(List notifs){
            super();
            this.notifs = notifs;
        }
        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            // Un LayoutInflater interprète la définition xml d'un layout
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_row, parent, false);
            return new MyHolder(v);
        }
        @Override
        public void onBindViewHolder(@NonNull MyHolder vh, int i) {
            //  (ré-)initialiser un view
            Notifications item = (Notifications) notifs.get(i);
            String title = item.getTitle();
            String sigle = item.getClassNumber();
            vh.tv.setText(title);
            vh.tv2.setText(sigle);
            //Si la notification est deja lue ote la pastille grise
            if(item.getRead()){
                int color = Color.parseColor("#AE6118");
                vh.tvRead.getBackground().mutate().setColorFilter(0x00FFFFFF, PorterDuff.Mode.SRC);
            }
            //On click pour afficher les informations d'une notification
            vh.itemView.setOnClickListener(e->{
                item.setRead(true);
                vh.tvRead.getBackground().mutate().setColorFilter(0x00FFFFFF, PorterDuff.Mode.SRC);
                Intent intent = new Intent(NotificationPage.this,NotificationInfo.class);
                intent.putExtra("title",item.getTitle());
                intent.putExtra("info",item.getInfo());
                intent.putExtra("sigle",item.getClassNumber());
                startActivity(intent);
            });
        }
        @Override
        public int getItemCount() {
            return notifs.size();
        }
    }
    // ViewHolder
    class MyHolder extends RecyclerView.ViewHolder{
        TextView tv;
        TextView tv2;
        TextView tvRead;
        MyHolder(View view){
            super(view);
            tv = view.findViewById(R.id.textView_Titre);
            tv2 = view.findViewById(R.id.textView_Sigle);
            tvRead = view.findViewById(R.id.Vue);
        }
    }
}
