package com.example.demo.Controller;
import com.example.demo.entities.Language;
import com.example.demo.services.Languageservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


@RestController
@RequestMapping("/api/languages")
public class LanguageController {

    @Autowired
    private Languageservice service;

    @PostMapping
    public Language addLanguage(@RequestBody Language language) {
        return service.addLanguage(language);
    }

    @GetMapping
    public List<Language> getAllLanguage() {
        return service.getAllLanguage();
    }

    @GetMapping("/page")
    public Page<Language> getLanguagesWithPagination(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        return service.getLanguagesWithPagination(page, size);
    }
    
    
    @PutMapping("/{id}")
    public Language updateLanguage(@PathVariable Long id, @RequestBody Language updatedLanguage) {
        return service.updateLanguage(id, updatedLanguage);
    }

    @DeleteMapping("/{id}")
    public String deleteLanguage(@PathVariable Long id) {
        return service.deleteLanguage(id);
    }

     @GetMapping("/{name}")
    public Optional<Language> getLanguageByName(@PathVariable String name) {
        return service.getLanguageByName(name);
    }
    @GetMapping("/customid/{id}")
    public Optional<Language> getLanguageByName1(@PathVariable Long id) {
        return service.getLanguageById(id);
    }
}
