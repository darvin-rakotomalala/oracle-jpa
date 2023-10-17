package com.poc.repository;

import com.poc.model.domain.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    Page<Tutorial> findByPublished(boolean published, Pageable pageable);
    List<Tutorial> findByTitleContaining(String title, Sort sort);
    Page<Tutorial> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
