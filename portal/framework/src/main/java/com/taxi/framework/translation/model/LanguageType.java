package com.taxi.framework.translation.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "languagetype")
public class LanguageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "language")
    private String language;

    public LanguageType(String language) {
        this.language = language;
    }

    public LanguageType() {

    }

}
