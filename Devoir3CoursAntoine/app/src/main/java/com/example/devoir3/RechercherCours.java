package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class RechercherCours extends AppCompatActivity {
    EditText inputRechercher;
    ArrayList<Cours> bdCours;
    ListView listCours;
    TextView test;
    ImageView imageprofilerecherche;
    private BottomNavigationView bottomNavigationView;
    ImageView ivRechercherCoursNotifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_cours);
        bdCours =new ArrayList<>();
        remplirBDCours();//met les cours
        //ca chercher les elements visuels
        test=findViewById(R.id.rechercherTitre);
        inputRechercher =findViewById(R.id.rechercher);
        listCours=findViewById(R.id.listeCours);
        inputRechercher.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //lorsque le texte change, la vue s'update
                updateListView(""+s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;


        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Cours temp: bdCours){
            map = new HashMap<>();
            map.put("titre", temp.getTitre());
            String nomComplet=temp.getProfesseurPrenom()+" "+temp.getProfesseurNom();
            String courriel=temp.getProfesseurPrenom()+"."+temp.getProfesseurNom()+"@umontreal.ca";
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            map.put("professeurComplet", nomComplet);
            map.put("professeurCourriel",courriel);
            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listItem.add(map);
    }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.rowrecherche,
                new String[] { "titre", "professeurComplet","professeurCourriel"}, new int[] { R.id.titreCours, R.id.nomProf,R.id.courrielProf});
        listCours.setAdapter(mSchedule);
        bottomNavigationView = findViewById(R.id.barnavigationrechecher);
        bottomNavigationView.setSelectedItemId(R.id.barnavigationrechecher);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){
                    Intent intent=new Intent(RechercherCours.this, MesCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent=new Intent(RechercherCours.this,RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.calendrier){
                    Intent intent=new Intent(RechercherCours.this, CalendarActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.message){
                    Intent intent=new Intent(RechercherCours.this, Messagerie.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

        });

        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        imageprofilerecherche = (ImageView) findViewById(R.id.imageprofilerecherche);
        imageprofilerecherche.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent intent = new Intent(RechercherCours.this, MonProfil.class);
                                                     startActivity(intent);
                                                 }
                                             }
        );

        //Lorsque l'utilisateur clique sur l'icône notification, il est ramené vers la page «NotificationPage»
        ivRechercherCoursNotifications = (ImageView) findViewById(R.id.ivRechercherCoursNotifications);
        ivRechercherCoursNotifications.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View v) {
                                                           Intent intent = new Intent(RechercherCours.this, NotificationPage.class);
                                                           startActivity(intent);
                                                       }
                                                   }
        );
    }

    /**
     * ajoute 10 cours pour tester application
     */
    public void remplirBDCours(){
        Cours temp=new Cours("IFT1015");
        bdCours.add(temp);
         temp=new Cours("IFT1025");
        bdCours.add(temp);
        temp=new Cours("IFT2015");
        bdCours.add(temp);
        temp=new Cours("IFT2905");
        bdCours.add(temp);
        temp=new Cours("IFT3911");
        bdCours.add(temp);
        temp=new Cours("IFT3151");
        bdCours.add(temp);
        temp=new Cours("MAT1600");
        bdCours.add(temp);
        temp=new Cours("MAT2600");
        bdCours.add(temp);
        temp=new Cours("ECN1050");
        bdCours.add(temp);

    }

    /**
     * change la list view selon l'input de l'utilisateur
     * @param debut input de lutilisateur
     */
    public void updateListView(String debut){

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;

        int longeur=debut.length();
        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Cours temp: bdCours){
            //ne prend que les elements avec le meme debut de string que linput utilisateur
            if(longeur<=temp.getTitre().length()&&debut.equals(temp.getTitre().substring(0,longeur))){
            map = new HashMap<>();
            map.put("titre", temp.getTitre());
            String nomComplet=temp.getProfesseurPrenom()+" "+temp.getProfesseurNom();
            String courriel=temp.getProfesseurPrenom()+"."+temp.getProfesseurNom()+"@umontreal.ca";
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            map.put("professeurComplet", nomComplet);
            map.put("professeurCourriel",courriel);
            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listItem.add(map);
            }
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.rowrecherche,
                new String[] { "titre", "professeurComplet","professeurCourriel"}, new int[] { R.id.titreCours, R.id.nomProf,R.id.courrielProf});
        listCours.setAdapter(mSchedule);

    }

}