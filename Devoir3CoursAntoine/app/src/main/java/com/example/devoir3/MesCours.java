package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class MesCours extends AppCompatActivity {
    TextView mescours;
    Utilisateur actuel;
    TextView nombredecours;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_cours);
        //met le titre mes cours
        mescours=findViewById(R.id.textView);
        mescours.setText(R.string.MesCours);
        //creer l'utilisateur
        actuel =new Utilisateur();
        //nombre de cours
        String nombrecoursString="Vous avez "+actuel.getTabCours().size()+" cours";

        nombredecours=findViewById(R.id.textViewf);
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
        bottomNavigationView=findViewById(R.id.bottommenumescours);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.mescours){

                    return true;
                }
                else if(item.getItemId()==R.id.search){

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