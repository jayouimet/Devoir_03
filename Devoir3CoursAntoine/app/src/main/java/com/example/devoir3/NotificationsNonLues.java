package com.example.devoir3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;

import android.media.Image;
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
public class NotificationsNonLues extends AppCompatActivity {
    RecyclerView rv;
    Button readNotifBtn;
    ImageView ivNotificationsNonLuesProfil;
    ImageView ivNotifNonLuesParametres;
    BottomNavigationView bottomNavigationMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_non_lues);
        readNotifBtn = findViewById(R.id.notificationsNonLues);
        readNotifBtn.setOnClickListener(e->{
            Intent intent = new Intent(NotificationsNonLues.this,NotificationPage.class);
            startActivity(intent);
        });
        setOnclickNavBar();
        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        ivNotificationsNonLuesProfil =  findViewById(R.id.ivNotificationPageProfil);
        ivNotificationsNonLuesProfil.setOnClickListener(e ->{
            Intent intent = new Intent(NotificationsNonLues.this, MonProfil.class);
            startActivity(intent);
        });
        // Trouve notre RecyclerList et y ajoute des séparateurs d'items
        rv = findViewById(R.id.recycler_view);
        rv.addItemDecoration(new DividerItemDecoration(NotificationsNonLues.this, DividerItemDecoration.VERTICAL));

        //Lorsque l'utilisateur clique sur l'icône paramètres, il est ramené vers la page « ParametresNotification »
        ivNotifNonLuesParametres =  findViewById(R.id.ivNotifNonLuesParametres);
        ivNotifNonLuesParametres.setOnClickListener(e ->{
            Intent intent = new Intent(NotificationsNonLues.this, ParametresNotification.class);
            startActivity(intent);
        });
        // Exécute la tâche asynchrone
        MyTask task = new MyTask();
        task.execute();
    }
    //Methode pour initialiser les fonctionnement de la barre de navigation
    public void setOnclickNavBar(){
        bottomNavigationMenu=findViewById(R.id.barnavigationNotifsNonLues);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.mescours){
                Intent intent=new Intent(NotificationsNonLues.this, MesCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.search){
                Intent intent=new Intent(NotificationsNonLues.this,RechercherCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.calendrier){
                Intent intent=new Intent(NotificationsNonLues.this,CalendarActivity.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.message){
                Intent intent=new Intent(NotificationsNonLues.this,Messagerie.class);
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
            MyAdapter adapter = new MyAdapter(notifs.notificationsUnread);
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

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_row, parent, false);
            return new MyHolder(v);
        }
        //  (ré-)initialiser un vie
        @Override
        public void onBindViewHolder(@NonNull MyHolder vh, int i) {
            Notifications item = (Notifications) notifs.get(i);
            if(!item.getRead()){
                String title = item.getTitle();
                String sigle = item.getClassNumber();
                vh.tv.setText(title);
                vh.tv2.setText(sigle);
                if(item.getRead()){
                    int color = Color.parseColor("#AE6118");
                    vh.tvRead.getBackground().mutate().setColorFilter(0x00FFFFFF, PorterDuff.Mode.SRC);
                }
                vh.itemView.setOnClickListener(e->{
                    item.setRead(true);
                    vh.tvRead.getBackground().mutate().setColorFilter(0x00FFFFFF, PorterDuff.Mode.SRC);

                    Intent intent = new Intent(NotificationsNonLues.this,NotificationInfo.class);
                    intent.putExtra("title",item.getTitle());
                    intent.putExtra("info",item.getInfo());
                    intent.putExtra("sigle",item.getClassNumber());

                    startActivity(intent);
                });
            }
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