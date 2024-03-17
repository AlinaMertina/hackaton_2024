package com.hackaton.hariart.service;

import com.hackaton.hariart.entity.Preference;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Profil;
import com.hackaton.hariart.entity.Publication;
import com.hackaton.hariart.entity.Tags;
import com.hackaton.hariart.repository.PublicationRepository;

@Service
public class Recommendation {
    @Autowired
    private PublicationRepository publicationRepository;

    public int getScorePercent(int note, int total){        
        return (int)((100 * note) / total);
    }

    public int getNumberToList(int percent){
        return (int)((20 * percent) / 100) ;
    }

    public List<Publication> proposer(Profil profil, int number){
        List<Publication> res = new ArrayList<>();
        List<Preference> preferences = profil.getPreferences();
        double total = profil.getNoteTotal();
        List<Tags> lstTag = new ArrayList<>();
        lstTag.add(null); 
        for(Preference preference : preferences){
            lstTag.set(0, preference.getTags());
            Pageable limit = PageRequest.of(0, getNumberToList((int)total));
            res.addAll(publicationRepository.findByTagsAndProfilNot(lstTag, profil, limit));
        }
        return res;
    }
}
