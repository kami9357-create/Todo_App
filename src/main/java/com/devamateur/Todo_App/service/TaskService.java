package com.devamateur.Todo_App.service;

import com.devamateur.Todo_App.dto.request.TaskPatchRequest;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getTasks(Boolean completed);
    TaskResponse getTaskById(Long id);
    List<TaskResponse> searchTasks(String keyword);
    TaskResponse createTask(TaskRequest request);
    TaskResponse updateTask(Long id, TaskRequest request);
    TaskResponse patchTask(Long id, TaskPatchRequest request);
    TaskResponse markTaskAsCompleted(Long id);
    TaskResponse markTaskAsUncompleted(Long id);
    void deleteTask(Long id);
}
