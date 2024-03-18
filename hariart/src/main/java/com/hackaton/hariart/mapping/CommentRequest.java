package com.hackaton.hariart.mapping;

public class CommentRequest {
    public int profil;
    public int publication;
    public int action = 8;
    public String commentaire;

    public CommentRequest(){}


    public int getProfil() {
        return profil;
    }


    public void setProfil(int profil) {
        this.profil = profil;
    }


    public int getPublication() {
        return publication;
    }


    public void setPublication(int publication) {
        this.publication = publication;
    }


    public int getAction() {
        return action;
    }


    public void setAction(int action) {
        this.action = action;
    }


    public String getCommentaire() {
        return commentaire;
    }


    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
}
