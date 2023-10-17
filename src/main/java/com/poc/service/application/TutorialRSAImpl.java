package com.poc.service.application;

import com.poc.mapper.TutorialMapper;
import com.poc.model.dto.TutorialDTO;
import com.poc.service.business.TutorialRSM;
import com.poc.utils.HelpPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TutorialRSAImpl implements TutorialRSA {

    private final TutorialRSM tutorialRSM;
    private final TutorialMapper tutorialMapper;

    @Override
    public HelpPage<TutorialDTO> getAllTutorialsByTitle(String title, Pageable pageable) {
        return tutorialMapper.toDTO(tutorialRSM.getAllTutorialsByTitle(title, pageable), pageable);
    }

    @Override
    public HelpPage<TutorialDTO> getByPublished(boolean published, Pageable pageable) {
        return tutorialMapper.toDTO(tutorialRSM.getByPublished(published, pageable), pageable);
    }

    @Override
    public List<TutorialDTO> getByTitleContainingSorted(String title, Sort sort) {
        return tutorialMapper.toDTO(tutorialRSM.getByTitleContainingSorted(title, sort));
    }

    @Override
    public HelpPage<TutorialDTO> getAllTutorials(int page, int size, String[] sort) {
        List<Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            // will sort more than 2 fields
            // sortOrder="field, direction"
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            // sort=[field, direction]
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        return tutorialMapper.toDTO(tutorialRSM.getAllTutorials(pagingSort), pagingSort);
    }

    @Override
    public HelpPage<TutorialDTO> getAllTutorialsPage(String title, int page, int size, String[] sort) {
        List<Order> orders = new ArrayList<>();
        if (sort[0].contains(",")) {
            // will sort more than 2 fields
            // sortOrder="field, direction"
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            // sort=[field, direction]
            orders.add(new Order(getSortDirection(sort[1]), sort[0]));
        }

        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
        if (title == null)
            return tutorialMapper.toDTO(tutorialRSM.getAllTutorials(pagingSort), pagingSort);
        else
            return tutorialMapper.toDTO(tutorialRSM.getAllTutorialsByTitle(title, pagingSort), pagingSort);
    }

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }
        return Sort.Direction.ASC;
    }

}
