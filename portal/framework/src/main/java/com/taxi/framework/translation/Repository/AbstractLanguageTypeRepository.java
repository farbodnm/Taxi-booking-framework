package com.taxi.framework.translation.Repository;

import com.taxi.framework.translation.model.LanguageType;
import com.taxi.framework.translation.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbstractLanguageTypeRepository extends JpaRepository<LanguageType, Integer> {

    boolean existsById(Long id);
    boolean existsByLanguage(String language);

}
