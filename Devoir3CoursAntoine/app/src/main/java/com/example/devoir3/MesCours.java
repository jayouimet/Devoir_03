package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MesCours extends AppCompatActivity {
    TextView mescours;
    Utilisateur actuel;
    TextView nombredecours;
    BottomNavigationView bottomNavigationView;
    ImageView imageProfileMescours;
    ImageView ivMesCoursNotifications;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_cours);
        //met le titre mes cours
        mescours=findViewById(R.id.mesCours);
        mescours.setText(R.string.MesCours);
        //creer l'utilisateur
        actuel =new Utilisateur();
        //nombre de cours
        String nombrecoursString="Vous avez "+actuel.getTabCours().size()+" cours";

        nombredecours=findViewById(R.id.textViewUniversitédeMtl);
        nombredecours.setText(nombrecoursString);

        View temp=findViewById(R.id.page);
        //va mettre le nom du cours
        for(int i=0;i<actuel.getTabCours().size();i++){
            TextView nomcours=temp.findViewWithTag("t"+i);
            nomcours.setText(actuel.getTabCours().get(i).getTitre());
        }
        //mettre invisible le reste des views
        for(int i=actuel.getTabCours().size();i<6;i++){
            TextView nomcours=temp.findViewWithTag("t"+i);
            nomcours.setVisibility(View.INVISIBLE);
            ImageView imageCours=temp.findViewWithTag("i"+i);
            imageCours.setVisibility(View.INVISIBLE);
        }
        bottomNavigationView=findViewById(R.id.bottomNavBar);
        bottomNavigationView.setSelectedItemId(R.id.mescours);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){

                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent=new Intent(MesCours.this,RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.calendrier){
                    Intent intent=new Intent(MesCours.this,CalendarActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.message){
                    Intent intent=new Intent(MesCours.this,Messagerie.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

        });

        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        imageProfileMescours = (ImageView) findViewById(R.id.imageProfileMescours);
        imageProfileMescours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MesCours.this, MonProfil.class);
                startActivity(intent);
            }
        }
        );


        //Lorsque l'utilisateur clique sur l'icône notification, il est ramené vers la page «NotificationPage»
        ivMesCoursNotifications = (ImageView) findViewById(R.id.ivMesCoursNotifications);
        ivMesCoursNotifications.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent = new Intent(MesCours.this, NotificationPage.class);
                                                        startActivity(intent);
                                                    }
                                                }
        );
    }


    /**
     * pour acceder cours en cliquant
     * @param v
     */
    public void accederCours(View v){

        Intent intent=new Intent(MesCours.this, CoursInterieur.class);
        String tag= ""+v.getTag();
        //va cherhcher le cours
        String number=tag.substring(tag.length()-1);
        int index=Integer.parseInt(number);

        intent.putExtra("CoursNom",actuel.getTabCours().get(index).getTitre());
        //passe le nom
        startActivity(intent);
    }

}