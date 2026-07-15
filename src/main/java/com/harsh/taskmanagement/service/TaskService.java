package com.harsh.taskmanagement.service;

import com.harsh.taskmanagement.dto.TaskRequestDto;
import com.harsh.taskmanagement.dto.TaskResponseDto;
import com.harsh.taskmanagement.entity.Task;
import com.harsh.taskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskResponseDto createTask(TaskRequestDto request) {

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .completed(request.getCompleted() != null ? request.getCompleted() : false)
                .build();

        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TaskResponseDto getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        return mapToResponse(task);
    }

    public TaskResponseDto updateTask(Long id, TaskRequestDto request) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.getCompleted());

        Task updatedTask = taskRepository.save(task);

        return mapToResponse(updatedTask);
    }

    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        taskRepository.delete(task);
    }

    private TaskResponseDto mapToResponse(Task task) {

        return TaskResponseDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .completed(task.getCompleted())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .build();
    }
}