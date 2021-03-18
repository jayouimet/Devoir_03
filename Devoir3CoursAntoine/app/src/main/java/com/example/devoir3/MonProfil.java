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
    TextView tvParamètres;
    ImageView ivMonProfilParametres;
    TextView tvDeconnexion;
    ImageView ivDeconnection;
    ImageView ivCloseMonProfil;
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


        //Lorsque l'utilisateur clique sur le texte « Liste de cours », il est ramené vers la page « Mes Cours »
        tvNotifications = (TextView) findViewById(R.id.tvNotifications);
        tvNotifications.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               Intent intent = new Intent(MonProfil.this, NotificationPage.class);
                                               startActivity(intent);
                                           }
                                       }
        );

        //Lorsque l'utilisateur clique sur l'icône « Liste de cours », il est ramené vers la page « Mes Cours »
        ivMonProfilNotification = (ImageView) findViewById(R.id.ivMonProfilNotification);
        ivMonProfilNotification.setOnClickListener(new View.OnClickListener() {
                                                     @Override
                                                     public void onClick(View v) {
                                                         Intent intent = new Intent(MonProfil.this, NotificationPage.class);
                                                         startActivity(intent);
                                                     }
                                                 }
        );

        //Lorsque l'utilisateur clique sur le texte « Déconnexion », il est ramené vers la page d'accueil «LoginActivity»
        tvDeconnexion = (TextView) findViewById(R.id.tvDeconnexion);
        tvDeconnexion.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   Intent intent = new Intent(MonProfil.this, LoginActivity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );

        //Lorsque l'utilisateur clique sur l'icône « Déconnexion », il est ramené vers la page d'accueil «LoginActivity»
        ivDeconnection = (ImageView) findViewById(R.id.ivDeconnection);
        ivDeconnection.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View v) {
                                                           Intent intent = new Intent(MonProfil.this, LoginActivity.class);
                                                           startActivity(intent);
                                                       }
                                                   }
        );

        //Lorsque l'utilisateur clique sur l'icône « Déconnexion », il est ramené vers la page d'accueil «LoginActivity»
        ivDeconnection = (ImageView) findViewById(R.id.ivDeconnection);
        ivDeconnection.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(MonProfil.this, LoginActivity.class);
                                                  startActivity(intent);
                                              }
                                          }
        );
                //Lorsque l'utilisateur clique sur l'icône « Déconnexion », il est ramené vers la page d'accueil «LoginActivity»
        ivMonProfilParametres = (ImageView) findViewById(R.id.ivMonProfilParametres);
        ivMonProfilParametres.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent(MonProfil.this, LoginActivity.class);
                                                  startActivity(intent);
                                              }
                                          }
        );

            //Lorsque l'utilisateur clique sur l'icône « Déconnexion », il est ramené vers la page d'accueil «LoginActivity»
        tvParamètres = (TextView) findViewById(R.id.tvParamètres);
        tvParamètres.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(MonProfil.this, LoginActivity.class);
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
                Intent intent=new Intent(MonProfil.this,CalendarActivity.class);
                startActivity(intent);
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

    //Lorsque l'utilisateur clique sur l'icône X, il est ramené vers la page précédente
    public void quitterMonProfil(View v){
        this.finish();
    }

    //Lorsque l'utilisateur clique sur paramètres, il est ramené vers la page paramètres
    public void ProfilversParametres(View v){
        this.finish();
    }
}