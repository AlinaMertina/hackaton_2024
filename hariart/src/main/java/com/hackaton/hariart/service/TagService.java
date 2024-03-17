package com.hackaton.hariart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackaton.hariart.entity.Preference;
import com.hackaton.hariart.repository.PreferenceRepository;

@Service
public class TagService {
    @Autowired
    PreferenceRepository preferenceRepository;

    public void savePreferences(Preference[] preferences){
        for (Preference preference : preferences) {
            preferenceRepository.save(preference);
        }
    }
}
