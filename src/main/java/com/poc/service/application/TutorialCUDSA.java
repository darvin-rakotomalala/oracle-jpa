package com.poc.service.application;

import com.poc.model.dto.TutorialDTO;

import java.util.List;

public interface TutorialCUDSA {
    public List<TutorialDTO> createTutorials(List<TutorialDTO> tutorials);
}
