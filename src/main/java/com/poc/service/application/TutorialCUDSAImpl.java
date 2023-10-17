package com.poc.service.application;

import com.poc.mapper.TutorialMapper;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.business.TutorialCUDSM;
import com.poc.service.business.TutorialRSM;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TutorialCUDSAImpl implements TutorialCUDSA {

    private final TutorialCUDSM tutorialCUDSM;
    private final TutorialRSM tutorialRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public List<TutorialDTO> createTutorials(List<TutorialDTO> tutorials) {
        return tutorialMapper.toDTO(tutorialCUDSM.createTutorials(tutorialMapper.toDO(tutorials)));
    }

}
