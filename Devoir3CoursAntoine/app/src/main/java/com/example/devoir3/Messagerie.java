package com.example.devoir3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Messagerie extends AppCompatActivity {
    GridView autreutilisateur;
    ListView messageutilisateur;
    ArrayList<Utilisateur> listeUtilisateur;
    Utilisateur vous;
    String autre="User 1";
    Button envoyer;
    EditText messageenvoye;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagerie);
        autreutilisateur=findViewById(R.id.autreutilisateur);
        messageutilisateur=findViewById(R.id.message);
        listeUtilisateur=new ArrayList<>();
        vous=new Utilisateur();
        envoyer=findViewById(R.id.buttonenvoyer);
        messageenvoye=findViewById(R.id.messageEdit);

        for(int i=1;i<16;i++){
            Utilisateur temp=new Utilisateur();
            temp.setNom(" "+i);
            temp.setPrenom("User");
            listeUtilisateur.add(temp);
        }
        ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> map;
        messageutilisateur.setDivider(null);
        messageutilisateur.setDividerHeight(0);

        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (Utilisateur temp: listeUtilisateur){
            map = new HashMap<>();

            String nomComplet=temp.getPrenom()+" "+temp.getNom();

            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            map.put("nomcomplet", nomComplet);

            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml
            Log.d("tage",nomComplet);
            listItem.add(map);
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter mSchedule = new SimpleAdapter (this.getBaseContext(), listItem, R.layout.elementmessage,
                new String[] { "nomcomplet"}, new int[] { R.id.nomutilisateurmessage});
        autreutilisateur.setAdapter(mSchedule);


        autreutilisateur.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                autre="User "+(position+1);
            }
        });
        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=messageenvoye.getText().toString();
                vous.getMessageHumain().add(message);
                setMessage();
            }
        });


    }
    public void setMessage(){
        ArrayList<HashMap<String, String>> listObjetMessage = new ArrayList<HashMap<String, String>>();
        //cette partie du code est base sur https://a-renouard.developpez.com/tutoriels/android/personnaliser-listview/
        //On déclare la HashMap qui contiendra les informations pour un item
        HashMap<String, String> mapMessage;


        //On refait la manip plusieurs fois avec des données différentes pour former les items de notre ListView
        for (String temp: vous.getMessageHumain()){
            mapMessage = new HashMap<>();



            //on insère un élément description que l'on récupérera dans le textView description créé dans le fichier row.xml
            mapMessage.put("message", temp);
            mapMessage.put("messageautre", "Les interfaces sont importantes");
            mapMessage.put("nomautre", autre);

            //on insère la référence à l'image (converti en String car normalement c'est un int) que l'on récupérera dans l'imageView créé dans le fichier row.xml

            listObjetMessage.add(mapMessage);
        }


        //Création d'un SimpleAdapter qui se chargera de mettre les items présents dans notre list (listItem) dans la vue row(chque cours)
        SimpleAdapter nouvelleSechule = new SimpleAdapter (this.getBaseContext(), listObjetMessage, R.layout.messagerange,
                new String[] { "message","messageautre","nomautre"}, new int[] { R.id.messagesoi,R.id.messagedeuser,R.id.nomAutre});
        messageutilisateur.setAdapter(nouvelleSechule);

    }
}