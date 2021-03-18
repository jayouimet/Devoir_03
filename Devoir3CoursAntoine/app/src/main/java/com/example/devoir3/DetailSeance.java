package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class DetailSeance extends AppCompatActivity {
    TextView titre;//titre cours
    ListView malist;//list view fichier
    Seance actuel;
    TextView lienTitre;
    TextView lienSpecifique;//lien de la seance
    TextView descriptionTitre;
    TextView descriptionSpecifique;
    BottomNavigationView bottomNavigationView;
    ImageView imageProfilSeance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_seance);
        //aller chercher les elements visuels
        titre=(TextView)findViewById(R.id.titreSeance);
        lienTitre=(TextView)findViewById(R.id.lien);
        lienSpecifique=(TextView)findViewById(R.id.lienSpecifique);
        descriptionTitre=(TextView)findViewById(R.id.descriptionTitre);
        descriptionSpecifique=(TextView)findViewById(R.id.descriptionSpecifique);
        bottomNavigationView=findViewById(R.id.barnavigationdetailseance);
        //met les elements statique
        descriptionTitre.setText(R.string.description);
        lienTitre.setText(R.string.LienCours);
        lienSpecifique.setText(R.string.lienRick);
        //va chercher les elements
        String titreSeance=getIntent().getStringExtra("SeanceNom");
        String descrptionSeance=getIntent().getStringExtra("SeanceDescription");
        descriptionSpecifique.setText(descrptionSeance);
        titre.setText(titreSeance);
        malist=(ListView)findViewById(R.id.listSeance);
        //Création de la ArrayList qui nous permettra de remplir la listView
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        actuel=new Seance(titreSeance);

        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        for (String nomFichier:actuel.getNomfichier()
             ) {
            map = new HashMap<String, String>();
            map.put("nom", nomFichier);
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier rangefichier.xml
            listItem.add(map);
        }
        //adaptateur entre vue et donne
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.rangefichier,
                new String[] { "nom"}, new int[] { R.id.nom});
        //On attribue à notre listView l'adapter que l'on vient de créer
        malist.setAdapter(mSchedule);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){
                    Intent intent=new Intent(DetailSeance.this, MesCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.search){
                    Intent intent=new Intent(DetailSeance.this,RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId()==R.id.calendrier){

                    return true;
                }
                else if(item.getItemId()==R.id.message){
                    Intent intent=new Intent(DetailSeance.this,Messagerie.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }

        });

        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        imageProfilSeance = (ImageView) findViewById(R.id.imageProfilSeance);
        imageProfilSeance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailSeance.this, MonProfil.class);
                startActivity(intent);
            }
        }
        );
    }
    public void clickProfil(View v){


    }
    public void quitterSeance(View v){
        this.finish();
    }

}