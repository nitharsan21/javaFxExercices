/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba.entites;

import java.time.LocalDate;

/**
 *
 * @author developpeur
 */
public class Repas {
    private LocalDate date ;
    private boolean soir = true;
    private String specialite;
    private int nbCouvert = 3;
    private boolean bio = false;
    private boolean vegen = false;
    private int  paf = 15;

    public Repas() {
        
    }

   
    
    

    public LocalDate getDate() {
        return date;
    }

    public boolean isSoir() {
        return soir;
    }

    public String getSpecialite() {
        return specialite;
    }

    public int getNbCouvert() {
        return nbCouvert;
    }

    public boolean isBio() {
        return bio;
    }

    public boolean isVegen() {
        return vegen;
    }

    public int getPaf() {
        return paf;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSoir(boolean soir) {
        this.soir = soir;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setNbCouvert(int nbCouvert) {
        this.nbCouvert = nbCouvert;
    }

    public void setBio(boolean bio) {
        this.bio = bio;
    }

    public void setVegen(boolean vegen) {
        this.vegen = vegen;
    }

    public void setPaf(int paf) {
        this.paf = paf;
    }

    @Override
    public String toString() {
        return "Repas{" + "date=" + date + ", soir=" + soir + ", specialite=" + specialite + ", nbCouvert=" + nbCouvert + ", bio=" + bio + ", vegen=" + vegen + ", paf=" + paf + '}';
    }
    

    
    
    
}
