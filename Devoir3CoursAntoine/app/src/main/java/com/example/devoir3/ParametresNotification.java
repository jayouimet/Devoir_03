package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ParametresNotification extends AppCompatActivity {
    ImageView ivParametresNotificationBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres_notification);



        //Lorsque l'utilisateur clique sur l'icône back, il est ramené vers la page «Paramètres»
//        ivParametresNotificationBack = (ImageView) findViewById(R.id.ivParametresNotificationBack);
//        ivParametresNotificationBack.setOnClickListener(new View.OnClickListener() {
//                                                       @Override
//                                                       public void onClick(View v) {
//                                                           Intent intent = new Intent(ParametresNotification.this, Parametres.class);
//                                                           startActivity(intent);
//                                                       }
//                                                   }
//        );
    }
}