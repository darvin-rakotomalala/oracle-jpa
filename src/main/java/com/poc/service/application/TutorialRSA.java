package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;
import com.poc.utils.HelpPage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TutorialRSA {
    HelpPage<TutorialDTO> getAllTutorialsByTitle(String title, Pageable pageable);
    HelpPage<TutorialDTO> getByPublished(boolean published, Pageable pageable);
    List<TutorialDTO> getByTitleContainingSorted(String title, Sort sort);
    HelpPage<TutorialDTO> getAllTutorials(int page, int size, String[] sort);
    HelpPage<TutorialDTO> getAllTutorialsPage(String title, int page, int size, String[] sort);
}
