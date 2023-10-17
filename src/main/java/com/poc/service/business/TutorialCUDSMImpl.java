package com.poc.service.business;

import com.poc.model.domain.Tutorial;
import com.poc.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TutorialCUDSMImpl implements TutorialCUDSM {

    private final TutorialRepository tutorialRepository;

    @Override
    public List<Tutorial> createTutorials(List<Tutorial> tutorials) {
        try {
            log.info("----- createTutorials");
            return tutorialRepository.saveAll(tutorials);
        } catch (Exception e) {
            log.error("Error createTutorials : {} {}", e.getMessage(), e);
            throw e;
        }
    }

}
