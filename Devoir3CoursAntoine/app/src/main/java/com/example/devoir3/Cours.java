package com.example.devoir3;

import java.util.ArrayList;

public class Cours {
    private String titre;
    private ArrayList<Seance> tabSeance;



    Cours(String titre){
        this.titre=titre;
        tabSeance=new ArrayList<>();
        for (int i=0;i<12;i++){
            Seance temp=new Seance("Séance théorique "+(i+1));
            temp.setDescription("Séance théorique sur les interfaces");
            tabSeance.add(temp);
            Seance demo=new Seance("Démonstration "+(i+1));
            demo.setDescription("Démonstration sur Android Studio");
            tabSeance.add(demo);
        }
    }

    public ArrayList<Seance> getTabSeance() {
        return tabSeance;
    }
    public String getTitre() {
        return titre;
    }
    public Seance trouverSeance(String titre){
        for (Seance seance:tabSeance
             ) {if(seance.getTitre()==titre){
                 return seance;}
        }

        return null;
    }
}
