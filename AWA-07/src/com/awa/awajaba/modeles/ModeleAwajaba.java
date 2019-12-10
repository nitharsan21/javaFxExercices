/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba.modeles;
import com.awa.awajaba.entites.EvaluationRepas;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    
    private static ModeleAwajaba modele = null;
    private EvaluationRepas evalRepas ;
    
    
    private ModeleAwajaba() {
        this.evalRepas = new EvaluationRepas();
    }

    public static ModeleAwajaba getModele() {
        if (modele == null) 
            modele = new ModeleAwajaba(); 
  
        return modele; 
    }

    public EvaluationRepas getEvaluation() {
        return evalRepas;
    }

    public void setEvaluation(EvaluationRepas evalRepas) {
        this.evalRepas = evalRepas;
    }
    
    
    
    
    
   
    
}
