package com.poc.service.business;

import com.poc.model.domain.Tutorial;

import java.util.List;

public interface TutorialCUDSM {
    public List<Tutorial> createTutorials(List<Tutorial> tutorials);
}
