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

}
