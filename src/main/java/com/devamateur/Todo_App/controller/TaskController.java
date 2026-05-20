package com.devamateur.Todo_App.controller;

import com.devamateur.Todo_App.service.TaskService;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.ApiResponse;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TaskController {
    TaskService taskService;

    @GetMapping
    public ApiResponse<List<TaskResponse>> getTasks(@RequestParam(required = false) Boolean completed) {
        ApiResponse<List<TaskResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.getTasks(completed));
        return apiResponse;
    }

    @GetMapping("/{id}")
    public ApiResponse<TaskResponse> getTaskById(@PathVariable Long id) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.getTaskById(id));
        return apiResponse;
    }

    @PostMapping
    public ApiResponse<TaskResponse> createTask(@RequestBody @Valid TaskRequest request) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.createTask(request));
        return apiResponse;
    }

    @PutMapping("/{id}")
    public ApiResponse<TaskResponse> updateTask(@PathVariable Long id, @RequestBody @Valid TaskRequest request) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.updateTask(id, request));
        return apiResponse;
    }

    @PatchMapping("/{id}/complete")
    public ApiResponse<TaskResponse> markTaskAsCompleted(@PathVariable Long id) {
        ApiResponse<TaskResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.markTaskAsCompleted(id));
        return apiResponse;
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTask(@PathVariable Long id) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        taskService.deleteTask(id);
        apiResponse.setResult("Task with ID " + id + " deleted successfully");
        return apiResponse;
    }
}
