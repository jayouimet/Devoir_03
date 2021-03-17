package com.example.devoir3;

import java.util.ArrayList;

public class Utilisateur {
    private String nom;//nom de famille de lutilisateur
    private String prenom;//prenom de lutilisateur
    private ArrayList<Cours> tabCours;//tableau de cours
    private ArrayList<String> messages;
    private ArrayList<String> messageHumain;
    Utilisateur(){
        messages=new ArrayList<>();
        messages.add("Bonjour");
        messages.add("Comment allez-vous");
        messages.add("Quel est votre professeur prefere");
        this.prenom="John";
        this.nom="Doe";
        tabCours=new ArrayList<>();
        //ajoute 6 cours
        tabCours.add(new Cours("IFT 2905"));
        tabCours.add(new Cours("IFT 1005"));
        tabCours.add(new Cours("IFT 2935"));
        tabCours.add(new Cours("IFT 3911"));
        tabCours.add(new Cours("IFT 3151"));
        tabCours.add(new Cours("MAT 2600"));
        messageHumain=new ArrayList<>();

    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ArrayList<Cours> getTabCours() {
        return tabCours;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public ArrayList<String> getMessages() {
        return messages;
    }

    public ArrayList<String> getMessageHumain() {
        return messageHumain;
    }
}
