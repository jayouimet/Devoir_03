package com.example.devoir3;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Parametres extends AppCompatActivity {
    BottomNavigationView bottomNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametres);
    }

    // Lorsque l'utilisateur clique sur l'icône "<", il est ramené vers la page précédente
    public void quitterParam(View v){ this.finish(); }

    // Méthode pour initialiser le fonctionnement de la barre de navigation
    public void setOnclickNavBar(){
        bottomNavigationMenu=findViewById(R.id.barnavigationNotifsInfo);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.mescours){
                Intent intent=new Intent(Parametres.this, MesCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.search){
                Intent intent=new Intent(Parametres.this,RechercherCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.calendrier){
                Intent intent=new Intent(Parametres.this,CalendarActivity.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.message){
                Intent intent=new Intent(Parametres.this,Messagerie.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}



