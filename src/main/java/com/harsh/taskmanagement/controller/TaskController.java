package com.harsh.taskmanagement.controller;

import com.harsh.taskmanagement.dto.TaskRequestDto;
import com.harsh.taskmanagement.dto.TaskResponseDto;
import com.harsh.taskmanagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDto createTask(@Valid @RequestBody TaskRequestDto request) {
        return taskService.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDto getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskResponseDto updateTask(@PathVariable Long id,
                                      @Valid @RequestBody TaskRequestDto request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully.";
    }
}