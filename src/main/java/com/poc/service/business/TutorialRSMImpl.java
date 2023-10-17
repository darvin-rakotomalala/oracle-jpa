package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TutorialRSMImpl implements TutorialRSM {

    private final TutorialRepository tutorialRepository;

    @Override
    public Page<Tutorial> getAllTutorials(Pageable pageable) {
        return tutorialRepository.findAll(pageable);
    }

    @Override
    public Page<Tutorial> getAllTutorialsByTitle(String title, Pageable pageable) {
        try {
            log.info("----- getAllTutorialsByTitle : {}", title);
            if (StringUtils.isBlank(title)) {
                return tutorialRepository.findAll(pageable);
            } else {
                return tutorialRepository.findByTitleContainingIgnoreCase(title, pageable);
            }
        } catch (Exception e) {
            log.error("Error getAllTutorialsByTitle : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Page<Tutorial> getByPublished(boolean published, Pageable pageable) {
        try {
            log.info("----- getByPublished : {}", published);
            return tutorialRepository.findByPublished(published, pageable);
        } catch (Exception e) {
            log.error("Error getByPublished : {} {}", e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<Tutorial> getByTitleContainingSorted(String title, Sort sort) {
        try {
            log.info("----- getByTitleContaining : {}", title);
            return tutorialRepository.findByTitleContaining(title, sort);
        } catch (Exception e) {
            log.error("Error getByTitleContaining : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
