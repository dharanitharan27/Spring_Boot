package com.example.demo.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.lang.NonNull; // Import @NonNull annotation

import com.example.demo.entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    // JPQL query to find a language by name
    @Query("SELECT l FROM Language l WHERE l.languageName = :languageName")
    Optional<Language> findByLanguageName(String languageName);

    @NonNull
    Optional<Language> findById(@NonNull Long id);  // Added @NonNull annotations
}
