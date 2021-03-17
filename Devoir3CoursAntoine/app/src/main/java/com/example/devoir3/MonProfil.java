package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MonProfil extends AppCompatActivity {

    TextView tvListeCours;
    ImageView ivMonProfilListeCours;
    TextView tvInfoPerso;
    ImageView ivMonProfilInfosPerso;
    TextView tvNotifications;
    ImageView ivMonProfilNotification;
    TextView tvFavoris;
    ImageView ivMonProfilCoeur;
    TextView tvParamètres;
    ImageView ivMonProfilParametres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);

        //Lorsque l'utilisateur clique sur le texte « Liste de cours », il est ramené vers la page « Mes Cours »
        tvListeCours = (TextView) findViewById(R.id.tvListeCours);
        tvListeCours.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(MonProfil.this, MesCours.class);
                                                     startActivity(intent);
                                                 }
                                             }
        );

        //Lorsque l'utilisateur clique sur l'icône « Liste de cours », il est ramené vers la page « Mes Cours »
        ivMonProfilListeCours = (ImageView) findViewById(R.id.ivMonProfilListeCours);
        ivMonProfilListeCours.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(MonProfil.this, MesCours.class);
                                                startActivity(intent);
                                            }
                                        }
        );

        //Lorsque l'utilisateur clique sur le texte « Liste de cours », il est ramené vers la page « Mes Cours »
        tvInfoPerso = (TextView) findViewById(R.id.tvInfoPerso);
        tvInfoPerso.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(MonProfil.this, InfoPerso.class);
                                                startActivity(intent);
                                            }
                                        }
        );

        //Lorsque l'utilisateur clique sur l'icône « Liste de cours », il est ramené vers la page « Mes Cours »
        ivMonProfilInfosPerso = (ImageView) findViewById(R.id.ivMonProfilInfosPerso);
        ivMonProfilInfosPerso.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         Intent intent = new Intent(MonProfil.this, InfoPerso.class);
                                                         startActivity(intent);
                                                     }
                                                 }
        );
    }
}