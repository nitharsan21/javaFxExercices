/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.awa.awajaba.entites;

/**
 *
 * @author developpeur
 */
public class EvaluationConvive {
    private int note = 2;
    private String  commentaire = "";
    private boolean bloque = false;

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    public boolean isBloque() {
        return bloque;
    }

    public EvaluationConvive() {
        
    }

    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "EvaluationRepas{" + "note=" + note + ", commentaire=" + commentaire + '}';
    }
    
    
}
