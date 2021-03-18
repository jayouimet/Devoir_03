package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoPerso extends AppCompatActivity {
    ImageView ivProfilInfoPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_perso);

        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        ivProfilInfoPerso = (ImageView) findViewById(R.id.ivProfilInfoPerso);
        ivProfilInfoPerso.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent(InfoPerso.this, MonProfil.class);
                                                startActivity(intent);
                                            }
                                        }
        );
    }

    //Lorsque l'utilisateur clique sur l'icône X, il est ramené vers la page précédente
    public void quitterInfoPerso(View v){
        this.finish();
    }
}