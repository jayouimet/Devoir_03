package com.example.devoir3;

import java.util.ArrayList;

public class Seance {
    private String description="Aucune descritption";
    private String titre;
    private ArrayList<String> nomfichier;
    Seance(String titre){
        this.titre=titre;
        nomfichier=new ArrayList<>();
        //ajoute toutes les fichiers dans les seances pour les tests
        for(int i=0;i<6;i++){
            String temp="Diapo "+(i+1);
            nomfichier.add(temp);

        }
        for(int i=0;i<6;i++){
            String fichier="Fichier "+(i+1);
            nomfichier.add(fichier);


        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setNomfichier(ArrayList<String> nomfichier) {
        this.nomfichier = nomfichier;
    }

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public ArrayList<String> getNomfichier() {
        return nomfichier;
    }
}
