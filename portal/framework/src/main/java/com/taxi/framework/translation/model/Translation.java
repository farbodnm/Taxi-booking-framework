package com.taxi.framework.translation.model;

import jakarta.persistence.*;

@Entity
public class Translation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;

    @ManyToOne
    @JoinColumn(name = "language_type_id", nullable = false)
    private LanguageType languageType;

    private String translationText;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Content getContent() { return content; }
    public void setContent(Content content) { this.content = content; }
    public LanguageType getLanguageType() { return languageType; }
    public void setLanguageType(LanguageType languageType) { this.languageType = languageType; }
    public String getTranslationText() { return translationText; }
    public void setTranslationText(String translationText) { this.translationText = translationText; }
}
