package com.example.demo.services;

import com.example.demo.entities.Language;
import com.example.demo.respositories.LanguageRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class Languageservice {

    @Autowired
    private LanguageRepository repository;

    public Language addLanguage(Language language) {
        return repository.save(language);
    }

     public List<Language> getAllLanguage() {
        return repository.findAll();
    }

    public Page<Language> getLanguagesWithPagination(int page, int size) {
        return repository.findAll(PageRequest.of(page, size));
    }
    
    public Language updateLanguage(Long id, Language updatedLanguage) {
        updatedLanguage.setId(id);
        return repository.save(updatedLanguage);
    }

    public String deleteLanguage(Long id) {
        repository.deleteById(id);
        return "Language deleted successfully";
    }
    public Optional<Language> getLanguageByName(String languageName) {
        return repository.findByLanguageName(languageName);
    }
    public Optional<Language> getLanguageById(Long id) {
        return repository.findById(id);
    }
}
