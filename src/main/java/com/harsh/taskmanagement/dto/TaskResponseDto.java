package com.harsh.taskmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskResponseDto {

    private Long id;

    private String title;

    private String description;

    private Boolean completed;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}