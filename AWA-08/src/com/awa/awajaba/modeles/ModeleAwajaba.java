/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba.modeles;
import com.awa.awajaba.entites.Repas;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    
    private static ModeleAwajaba modele = null;
    private Repas repas ;
    
    
    private ModeleAwajaba() {
        this.repas = new Repas();
    }

    public static ModeleAwajaba getModele() {
        if (modele == null) 
            modele = new ModeleAwajaba(); 
  
        return modele; 
    }

    public Repas getRepas() {
        return repas;
    }

    public void setRepas(Repas evalRepas) {
        this.repas = evalRepas;
    }
    
    
    
    
    
   
    
}
