/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.awa.awajaba.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author developpeur
 */
public class Hote extends Membre {

    private List<Specialite> specialites = new ArrayList<Specialite>(); 
    private Boolean isHote = false;

    public Hote() {
    }
    
    public List<Specialite> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Specialite> specialites) {
        this.specialites = specialites;
    }
    
    public Boolean getIsHote() {
        return isHote;
    }

    public void setIsHote(Boolean isHote) {
        this.isHote = isHote;
    }

    @Override
    public String toString() {
        return "Hote{" + "specialites=" + specialites + ", isHote=" + isHote + '}';
    }

    
    
    
   
    
    
    
    
}
