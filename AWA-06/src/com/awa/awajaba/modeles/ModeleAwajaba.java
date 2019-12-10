/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba.modeles;
import com.awa.awajaba.entites.EvaluationConvive;

/**
 *
 * @author developpeur
 */
public class ModeleAwajaba {
    
    private static ModeleAwajaba modele = null;
    private EvaluationConvive evalConvive ;
    
    
    private ModeleAwajaba() {
        this.evalConvive = new EvaluationConvive();
    }

    public static ModeleAwajaba getModele() {
        if (modele == null) 
            modele = new ModeleAwajaba(); 
  
        return modele; 
    }

    public EvaluationConvive getEvaluation() {
        return evalConvive;
    }

    public void setEvaluation(EvaluationConvive evalRepas) {
        this.evalConvive = evalRepas;
    }
    
    
    
    
    
   
    
}
