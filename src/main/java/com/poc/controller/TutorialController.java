package com.poc.controller;

import com.poc.constraint.validation.TutorialValidator;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.application.TutorialCUDSA;
import com.poc.service.application.TutorialRSA;
import com.poc.utils.HelpPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "tutorials")
public class TutorialController {

    private final TutorialCUDSA tutorialCUDSA;
    private final TutorialRSA tutorialRSA;
    private final TutorialValidator tutorialValidator;

    @InitBinder("tutorialDTO")
    protected void initTutorialDTOBinder(WebDataBinder webDataBinder) {
        webDataBinder.setValidator(tutorialValidator);
    }

    @Operation(summary = "WS used to save all tutorials")
    @PostMapping
    public List<TutorialDTO> createTutorials(@RequestBody @Validated List<TutorialDTO> tutorials) {
        return tutorialCUDSA.createTutorials(tutorials);
    }

    @Operation(summary = "WS used to get all tutorials")
    @GetMapping
    public HelpPage<TutorialDTO> getAllTutorials(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return tutorialRSA.getAllTutorialsByTitle(title, pageable);
    }

    @Operation(summary = "WS used to get all tutorials published")
    @GetMapping("/published")
    public HelpPage<TutorialDTO> getByPublished(
            @RequestParam(name = "published", required = true) boolean published,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size,
            @RequestParam(name = "sortBy", defaultValue = "level", required = false) String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return tutorialRSA.getByPublished(published, pageable);
    }

    @Operation(summary = "WS used to get all tutorials by title sorted")
    @GetMapping("/title")
    public List<TutorialDTO> getByTitleContainingSorted(
            @RequestParam(name = "title", defaultValue = "at", required = true) String title,
            @RequestParam(name = "sortBy", defaultValue = "level", required = false) String sortBy) {
        return tutorialRSA.getByTitleContainingSorted(title, Sort.by(sortBy));
    }

    @Operation(summary = "WS used to get all tutorials sorted")
    @GetMapping("/sorted")
    public HelpPage<TutorialDTO> getAllTutorials(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        return tutorialRSA.getAllTutorials(page, size, sort);
    }

    @Operation(summary = "WS used to get tutorials by title paged and sorted")
    @GetMapping("/byTitleSorted")
    public HelpPage<TutorialDTO> getAllTutorialsPage(
            @RequestParam(name = "title", defaultValue = "at", required = true) String title,
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "15", required = false) int size,
            @RequestParam(defaultValue = "id,desc") String[] sort) {
        return tutorialRSA.getAllTutorialsPage(title, page, size, sort);
    }

}
