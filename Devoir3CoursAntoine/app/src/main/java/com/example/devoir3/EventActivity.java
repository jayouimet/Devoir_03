package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.devoir3.obj.calendar.CalendarEvent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EventActivity extends AppCompatActivity {
    private ImageButton homeworkActivityProfileButton;
    private ImageButton homeworkActivityCloseButton;
    private Button uploadHomeworkButton;

    private TextView homeworkTitleTextView;
    private TextView homeworkDescriptionTextView;

    private BottomNavigationView homeworkActivityNavBar;

    private CalendarEvent calendarEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        // On récupère les arguments passés à la création de l'activité
        calendarEvent = getIntent().getParcelableExtra("calendarEvent");
        // Référence de l'UI à la logique
        homeworkActivityProfileButton = findViewById(R.id.homeworkActivityProfileButton);
        homeworkActivityCloseButton = findViewById(R.id.homeworkActivityCloseButton);
        uploadHomeworkButton = findViewById(R.id.uploadHomeworkButton);

        homeworkTitleTextView = findViewById(R.id.homeworkTitleTextView);
        homeworkDescriptionTextView = findViewById(R.id.homeworkDescriptionTextView);

        homeworkActivityNavBar = findViewById(R.id.homeworkActivityNavBar);
        // On ajoute la fermeture de l'activité comme action du bouton
        homeworkActivityCloseButton.setOnClickListener(e->{
            this.finish();
        });
        // Démarrage de l'activité au click du bouton de profil
        homeworkActivityProfileButton.setOnClickListener(e->{
            Intent intent = new Intent(EventActivity.this, MonProfil.class);
            startActivity(intent);
        });

        uploadHomeworkButton.setOnClickListener(e->{

        });

        homeworkActivityNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            // Démarrage de l'activité dépendemment du bouton cliqué
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mescours){
                    Intent intent=new Intent(EventActivity.this, MesCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.search){
                    Intent intent=new Intent(EventActivity.this, RechercherCours.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.calendrier){
                    Intent intent=new Intent(EventActivity.this, CalendarActivity.class);
                    startActivity(intent);
                    return true;
                }
                else if(item.getItemId() == R.id.message){
                    Intent intent=new Intent(EventActivity.this, Messagerie.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        // Affichage de l'information de l'évènement
        homeworkTitleTextView.setText(calendarEvent.title);
        homeworkDescriptionTextView.setText(calendarEvent.description);
    }
}