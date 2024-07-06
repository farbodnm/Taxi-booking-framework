package com.taxi.framework.translation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class LanguageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String language;

    @OneToMany(mappedBy = "languageType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Translation> translations;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public Set<Translation> getTranslations() { return translations; }
    public void setTranslations(Set<Translation> translations) { this.translations = translations; }
}
