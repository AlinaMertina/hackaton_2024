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

    @Transactional
    public void react(Profil profil, Publication publication, Action action){
        List<Preference> preferences = profil.getPreferences();
        List<Tags> tags = publication.getTags();
        for (Preference preference : preferences) {
            if(tags.contains(preference.getTags())){
                Preference temp = preference;
                temp.setNote((temp.getNote() + action.getNote()));
                preferenceRepository.save(temp);
            }else{
                Preference temp = preference;
                int note = action.getNote();
                temp.setNote(note);
                preferenceRepository.save(temp);
            }
        }
        publication.setNombreVue(publication.getNombreVue() + 1);
        publicationRepository.save(publication);
    }

    public void comment(Profil profil, Publication publication, Commentaire commentaire){
        List<Preference> preferences = profil.getPreferences();
        List<Tags> tags = publication.getTags();
        for (Preference preference : preferences) {
            if(tags.contains(preference.getTags())){
                Preference temp = preference;
                temp.setNote((temp.getNote() + 5));
                preferenceRepository.save(temp);
            }else{
                Preference temp = preference;
                int note = 5;
                temp.setNote(note);
                preferenceRepository.save(temp);
            }
        }
        commentaireRepository.save(commentaire);
        publication.setNombreVue(publication.getNombreVue() + 1);
        publicationRepository.save(publication);
    }   
}
