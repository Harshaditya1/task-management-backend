package com.harsh.taskmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequestDto {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private Boolean completed;
}