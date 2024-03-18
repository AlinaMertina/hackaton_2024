package com.hackaton.hariart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Action;
import com.hackaton.hariart.entity.Commentaire;
import com.hackaton.hariart.entity.Preference;
import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.entity.Tags;
import com.hackaton.hariart.repository.CommentaireRepository;
import com.hackaton.hariart.repository.PreferenceRepository;
import com.hackaton.hariart.repository.PublicationRepository;

import jakarta.transaction.Transactional;

@Service
public class Interact {
    @Autowired
    private PreferenceRepository preferenceRepository;
    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private CommentaireRepository commentaireRepository;


    public Preference contains(Tags tag, List<Preference> preferences){
        for (Preference preference : preferences) {
            if(tag.getIdTag() == preference.getTags().getIdTag()    ){
                return preference;
            }
        }
        return null;
    } 

    @Transactional
    public void react(Profil profil, Publication publication, Action action){
        List<Preference> preferences = profil.getPreferences();
        List<Tags> tags = publication.getTags();
        Preference preference = null;
        for (Tags tag : tags) {
            preference = this.contains(tag, preferences);
            if(preference == null){
                preference = new Preference();
                preference.setProfil(profil);
                preference.setTags(tag);
                preference.setNote(action.getNote());
            }else{
                preference.setNote(preference.getNote() + action.getNote());
            }
            preferenceRepository.save(preference);
        }
        publication.setNombreVue(publication.getNombreVue() + 1);
        publicationRepository.save(publication);
    }

    public void comment(Profil profil, Publication publication, Action action, Commentaire commentaire){
        react(profil, publication, action);
        commentaireRepository.save(commentaire);
    }   
}
