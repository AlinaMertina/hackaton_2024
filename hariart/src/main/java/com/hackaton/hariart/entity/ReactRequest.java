package com.hackaton.hariart.entity;

public class ReactRequest {
    public Profil profil;
    public Publication publication;
    public Action action;


    public ReactRequest(){}

    public Profil getProfil() {
        return profil;
    }
    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    public Publication getPublication() {
        return publication;
    }
    public void setPublication(Publication publication) {
        this.publication = publication;
    }
    public Action getAction() {
        return action;
    }
    public void setAction(Action action) {
        this.action = action;
    }

    
}
