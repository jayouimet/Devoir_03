package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

public class Messagerie extends AppCompatActivity {
    GridView autreutilisateur;
    ListView messageutilisateur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);
        autreutilisateur=findViewById(R.id.autreutilisateur);
        messageutilisateur=findViewById(R.id.message);
    }
}