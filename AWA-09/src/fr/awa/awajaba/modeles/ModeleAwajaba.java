/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.modeles;

import fr.awa.awajaba.entities.Hote;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    
    private static ModeleAwajaba modele = null;
    private Hote hote ;
    
    
    private ModeleAwajaba() {
        this.hote = new Hote();
    }

    public static ModeleAwajaba getModele() {
        if (modele == null) 
            modele = new ModeleAwajaba(); 
  
        return modele; 
    }

    public Hote getHote() {
        return hote;
    }

    public void setHote(Hote evalRepas) {
        this.hote = evalRepas;
    }
    
}
