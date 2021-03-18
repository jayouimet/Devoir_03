package com.example.devoir3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

public class Messagerie extends AppCompatActivity {
    GridView autreutilisateur;
    ListView messageutilisateur;
    ArrayList<Utilisateur> listeUtilisateur;
    Utilisateur vous;
    String autre = "User 1";
    Button envoyer;
    EditText messageenvoye;
    EditText rechercherUser;
    BottomNavigationView bottomNavigationMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);
        //va chercher les elements visuels
        autreutilisateur = findViewById(R.id.autreutilisateur);
        bottomNavigationMenu = findViewById(R.id.barnavigationmessagerie);
        messageutilisateur = findViewById(R.id.message);

        envoyer = findViewById(R.id.buttonenvoyer);
        messageenvoye = findViewById(R.id.messageEdit);
        rechercherUser = findViewById(R.id.rechercheruser);
        listeUtilisateur = new ArrayList<>();
        vous = new Utilisateur();
        //creer d'autre utilisateur
        for (int i = 1; i < 16; i++) {
            Utilisateur temp = new Utilisateur();
            temp.setNom(" " + i);
            temp.setPrenom("User");
            listeUtilisateur.add(temp);
        }

        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        //fait disparaitre les lignes entre messages
        messageutilisateur.setDivider(null);
        messageutilisateur.setDividerHeight(0);

        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre Gridview
        for (Utilisateur temp : listeUtilisateur) {
            map = new HashMap<>();

            String nomComplet = temp.getPrenom() + " " + temp.getNom();

            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier messagerange.xml
            map.put("nomcomplet", nomComplet);

            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listItem.add(map);
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chaqu utilisateur)
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.elementmessage,
                new String[]{"nomcomplet"}, new int[]{R.id.nomutilisateurmessage});
        autreutilisateur.setAdapter(mSchedule);

        //si on click sur un utilisateur
        autreutilisateur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>)
                        autreutilisateur.getItemAtPosition(position);
                //on trouve le nom de lutilisateur
                autre = map.get("nomcomplet");
            }
        });
        envoyer.setBackgroundColor(Color.BLACK);
        //si on clique sur le boutton
        envoyer.setOnClickListener(v -> {
            //cherche le string dans la boite
            String message = messageenvoye.getText().toString();
            vous.getMessageHumain().add(message);
            //envoie un message
            setMessage();
        });
        //si l'utilisateur cherche un user particulier, s'update au fur et a mesure
        rechercherUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                refreshUser("" + s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //defenie ce que les boutons de la barre de navigation fait
        bottomNavigationMenu.setSelectedItemId(R.id.message);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mescours) {
                    Intent intent = new Intent(Messagerie.this, MesCours.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.search) {
                    Intent intent = new Intent(Messagerie.this, RechercherCours.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.calendrier) {
                    Intent intent = new Intent(Messagerie.this, CalendarActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.message) {

                    return true;
                }
                return false;
            }
        });

    }

    /**
     * permet de mettre le message ecrit par l'utilisateur
     */
    public void setMessage() {
        ArrayList<HashMap<String, String>> listObjetMessage = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> mapMessage;


        //On refait la manip plusieurs fois avec les differents messages
        for (String temp : vous.getMessageHumain()) {
            mapMessage = new HashMap<>();
            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            mapMessage.put("message", temp);
            mapMessage.put("messageautre", "Les interfaces sont importantes");
            mapMessage.put("nomautre", autre);
            listObjetMessage.add(mapMessage);
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(paires de messages)
        SimpleAdapter nouvelleSechule = new SimpleAdapter(this.getBaseContext(), listObjetMessage, R.layout.messagerange,
                new String[]{"message", "messageautre", "nomautre"}, new int[]{R.id.messagesoi, R.id.messagedeuser, R.id.nomAutre});
        messageutilisateur.setAdapter(nouvelleSechule);
        // messageutilisateur.smoothScrollToPosition(messageutilisateur.getLastVisiblePosition());
    }

    /**
     * @param debut debut de mot ecris par lutilisateur
     */
    public void refreshUser(String debut) {
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        messageutilisateur.setDivider(null);
        messageutilisateur.setDividerHeight(0);
        int longueur = debut.length();
        //On refait la manip plusieurs fois avec des données différentes pour former les utilisateu de notre GridView
        for (Utilisateur temp : listeUtilisateur) {
            String nomcomplet = temp.getPrenom() + temp.getNom();

            if (longueur <= nomcomplet.length() && debut.equals(nomcomplet.substring(0, longueur))) {
                map = new HashMap<>();

                String nomComplet = temp.getPrenom() + " " + temp.getNom();

                //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
                map.put("nomcomplet", nomComplet);

                //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

                listItem.add(map);
            }
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue elementmessage
        SimpleAdapter mSchedule = new SimpleAdapter(this.getBaseContext(), listItem, R.layout.elementmessage,
                new String[]{"nomcomplet"}, new int[]{R.id.nomutilisateurmessage});
        autreutilisateur.setAdapter(mSchedule);


    }
}