package com.taxi.framework.translation.Repository;

import com.taxi.framework.translation.model.LanguageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractLanguageTypeRepository extends JpaRepository<LanguageType, Integer> {
}
