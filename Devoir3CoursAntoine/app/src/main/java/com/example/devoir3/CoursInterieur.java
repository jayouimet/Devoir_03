package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class CoursInterieur extends AppCompatActivity {
    private ListView maListViewPerso;
    private Cours actuel;
    private TextView titre;
    private Utilisateur utilisateur;
    BottomNavigationView bottomNavigationMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours_interieur);
        utilisateur=new Utilisateur();//utilisateur actuel
        String titreCours=getIntent().getStringExtra("CoursNom");//va chercher le nom du cours
        actuel =new Cours(titreCours);//cours actuel
        //va chercher la liste view
        maListViewPerso=(ListView)findViewById(R.id.listSeance);
        titre=findViewById(R.id.titreCoursInterieur);
        titre.setText(actuel.getTitre());//mes le titre du cours
        bottomNavigationMenu=findViewById(R.id.barnavigationcoursinterieur);
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;


        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Seance temp: actuel.getTabSeance()
             ) {
            map = new HashMap<>();
            map.put("titre", temp.getTitre());
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            map.put("description", temp.getDescription());
            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listItem.add(map);

        }

        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.rangeseance,
                new String[] { "titre", "description"}, new int[] { R.id.titre, R.id.description});


        //On attribue à notre listView l'adapter que l'on vient de créer
        maListViewPerso.setAdapter(mSchedule);

        //Enfin on met un écouteur d'évènement sur notre listView
        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                //on récupère la HashMap contenant les infos de notre item (titre, description, img)
                HashMap<String, String> map = (HashMap<String, String>) maListViewPerso.getItemAtPosition(position);
                //on trouve la seance
                String titre=map.get("titre");
                Seance seance= actuel.trouverSeance(
                        titre
                );
                //on creer l'intention
                Intent intent=new Intent(CoursInterieur.this, DetailSeance.class);
                //on veut transmettre le titre et la description
                intent.putExtra("SeanceNom",seance.getTitre()
                );
                intent.putExtra("SeanceDescription",seance.getDescription());
                startActivity(intent);


            }
        });
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){
                    Intent intent=new Intent(CoursInterieur.this, MesCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent=new Intent(CoursInterieur.this,RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.calendrier){

                    return true;
                }
                else if(item.getItemId()==R.id.message){

                    return true;
                }
                return false;
            }
        });
    }
    public void clickProfil(View v){
        Log.d("tag","icone profile");
    }
    public void clickHamburger(View v){Log.d("tag","hamburger");
            
    }



}