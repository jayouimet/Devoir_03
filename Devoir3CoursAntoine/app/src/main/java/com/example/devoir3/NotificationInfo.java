package com.example.devoir3;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class NotificationInfo extends AppCompatActivity {
    ImageView imageNotificationInfoProfil;
    BottomNavigationView bottomNavigationMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_info);
        setOnclickNavBar();
        TextView tv1 = (TextView)findViewById(R.id.info);
        TextView tv2 = (TextView)findViewById(R.id.titre);
        TextView tv3 = (TextView)findViewById(R.id.sigle);
        Bundle b = getIntent().getExtras();
        tv2.setText(b.getString("title"));
        tv1.setText(b.getString("info"));
        tv3.setText(b.getString("sigle"));


        //Lorsque l'utilisateur clique sur l'icône profil, il est ramené vers la page « Mon Profil »
        imageNotificationInfoProfil = (ImageView) findViewById(R.id.imageNotificationInfoProfil);
        imageNotificationInfoProfil.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intent = new Intent(NotificationInfo.this, MonProfil.class);
                                                        startActivity(intent);
                                                    }
                                                }
        );
    }
    public void setOnclickNavBar(){
        bottomNavigationMenu=findViewById(R.id.barnavigationNotifsInfo);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(item -> {
            if(item.getItemId()==R.id.mescours){
                Intent intent=new Intent(NotificationInfo.this, MesCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.search){
                Intent intent=new Intent(NotificationInfo.this,RechercherCours.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.calendrier){
                Intent intent=new Intent(NotificationInfo.this,CalendarActivity.class);
                startActivity(intent);
                return true;
            }
            else if(item.getItemId()==R.id.message){
                Intent intent=new Intent(NotificationInfo.this,Messagerie.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}