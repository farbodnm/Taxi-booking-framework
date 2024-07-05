package com.taxi.framework.translation.Repository;

import com.taxi.framework.translation.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbstractTranslationRepository  extends JpaRepository<Translation, Integer> {
    List<Translation> findByContentIdAndLanguageTypeId(Long contentId, Long languageTypeId);
    Translation findByContentIdAndLanguageTypeLanguage(Long contentId, String language);
}
