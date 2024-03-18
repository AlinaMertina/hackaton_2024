package com.hackaton.hariart.mapping;

import com.hackaton.hariart.entity.Action;
import com.hackaton.hariart.entity.Commentaire;
import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;

public class CommentRequest {
    public Profil profil;
    public Publication publication;
    public Action action;
    public Commentaire commentaire;


    public CommentRequest(){}

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

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
}
