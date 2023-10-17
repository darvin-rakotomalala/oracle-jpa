package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TutorialRSM {
    Page<Tutorial> getAllTutorials(Pageable pageable);
    public Page<Tutorial> getAllTutorialsByTitle(String title, Pageable pageable);
    Page<Tutorial> getByPublished(boolean published, Pageable pageable);
    List<Tutorial> getByTitleContainingSorted(String title, Sort sort);
}
