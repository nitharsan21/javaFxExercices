/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.entities;

/**
 *
 * @author developpeur
 */
public abstract class Membre {
    
   private int identifiant = 1;
   private String nom = "Potter";
   private String prenom = "Harry";
   private String email = "Harry.potter.sio@gmail.com" ;
   

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public String toString() {
        return "Membre{" + "identifiant=" + identifiant + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }

   
   
   
   
            
    
}
