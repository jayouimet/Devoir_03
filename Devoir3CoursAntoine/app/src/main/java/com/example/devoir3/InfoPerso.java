package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPerso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_perso);
    }

    //Lorsque l'utilisateur clique sur la flèche, il est ramené vers la page précédente, soit la page «Mon Profil»
    public void quitterInfoPerso(View v){
        this.finish();
    }
}