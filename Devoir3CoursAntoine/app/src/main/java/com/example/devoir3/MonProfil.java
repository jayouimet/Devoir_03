package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

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
    BottomNavigationView bottomNavigationMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon_profil);
        bottomNavigationMenu=findViewById(R.id.bottommonprofile);
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
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.mescours){
                Intent intent=new Intent(MonProfil.this, MesCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.search){
                Intent intent=new Intent(MonProfil.this,RechercherCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.calendrier){

                return true;
            }
            else if(item.getItemId()==R.id.message){
                Intent intent=new Intent(MonProfil.this,Messagerie.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}