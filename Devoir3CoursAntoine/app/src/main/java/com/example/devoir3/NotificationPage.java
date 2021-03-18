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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class NotificationPage extends AppCompatActivity {
    RecyclerView rv;
    Button readNotifBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_page);

        readNotifBtn = findViewById(R.id.nonLues);
        readNotifBtn.setOnClickListener(e->{
            Intent intent = new Intent(NotificationPage.this,NotificationsNonLues.class);
            startActivity(intent);
        });
        // Trouve notre RecyclerList et y ajoute des séparateurs d'items
        rv = findViewById(R.id.recycler_view);
        rv.addItemDecoration(new DividerItemDecoration(NotificationPage.this, DividerItemDecoration.VERTICAL));


        // Exécute la tâche asynchrone
        MyTask task = new MyTask();
        task.execute();
    }

    // Définis une tâche asynchrone. Cela permet d'exécuter une tâche en arrière plan sans geler
    // l'interface.
    class MyTask extends AsyncTask<Void, Void, Notification>{
        @Override
        protected Notification doInBackground(Void... voids) { // Voir vararg en java
            // Cette méthode est exécutée en arrière plan, dans un thread distinct de celui de
            // l'interface: Elle n'a donc pas accès à l'interface!


            Notification notifs = new Notification();
            Log.i("this","Loading Notification in the background");
            return notifs;
        }

        @Override
        protected void onPostExecute(Notification notifs) {
            // Cette méthode est exécutée une fois la tâche asynchrone complétée, et dans le
            // thread d'interface. Il est donc sécuritaire d'accéder l'interface ici.

            super.onPostExecute(notifs);
            Log.i("this","Notification on post EXEC");
            MyAdapter adapter = new MyAdapter(notifs.notifications);
            rv.setAdapter(adapter);
        }
    }

    // Pour utiliser un RecyclerView, il faut créer un Adapter, et l'attacher au RecyclerView.
    // L'Adapter est en charge de gêrer le lifecycle des entrées de la liste: Il crée des Views
    // pour populer la liste lorsque nécessaire, les détruit lorsqu'il ne sont plus nécessaire; ou
    // encore les recycle lorsqu'un item quitte l'écran et qu'un autre item entre l'écran.
    class MyAdapter extends RecyclerView.Adapter<MyHolder>{
        List notifs;

        MyAdapter(List notifs){
            super();
            this.notifs = notifs;
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            // Cette méthode a la tâche de créer des Views lorsque l'Adapter le demande. Ils
            // doivent être encapsulés dans des ViewHolders.

            // Un LayoutInflater interprète la définition xml d'un layout, et crée la View
            // correspondante.
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_row, parent, false);

            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder vh, int i) {
            // Cette méthode est appelée pour (ré-)initialiser un View. C'est elle qui est en
            // charge de remplir les views avec le bon contenu.
            Notifications item = (Notifications) notifs.get(i);
            String title = item.getTitle();
            Log.i("this",title);
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

                Intent intent = new Intent(NotificationPage.this,NotificationInfo.class);
                intent.putExtra("title",item.getTitle());
                intent.putExtra("info",item.getInfo());
                intent.putExtra("sigle",item.getClassNumber());

                startActivity(intent);


            });

        }

        @Override
        public int getItemCount() {
            // Cette fonction doit retourner le nombre d'item que contient la liste que le
            // RecyclerView représente.
            return notifs.size();
        }
    }

    // Un ViewHolder encapsule un View afin de lui adjoindre des données pertinentes. Sa principal
    // est de se "souvenir" du résultat des appels à findViewById(), qui sont couteux à exécuter.
    // Ainsi, il n'est nécessaire d'exécuter cette commande qu'une seule fois, à la création
    // du View, et non pas chaque fois qu'on veut y référer.
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
