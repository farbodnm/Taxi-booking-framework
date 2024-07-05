package com.taxi.framework.translation.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String section;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Translation> translations;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
    public Set<Translation> getTranslations() { return translations; }
    public void setTranslations(Set<Translation> translations) { this.translations = translations; }
}
