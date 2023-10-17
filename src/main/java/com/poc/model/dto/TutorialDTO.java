package com.poc.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TutorialDTO {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int grade;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean published;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date createdAt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date updatedAt;
}
