package com.taxi.framework.translation.Repository;

import com.taxi.framework.translation.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractContentRepository extends JpaRepository<Content, Long> {
}
