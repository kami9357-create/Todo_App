package com.devamateur.Todo_App.Service;

import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> getTasks(Boolean completed);
    TaskResponse getTaskById(Long id);
    TaskResponse createTask(TaskRequest request);
    TaskResponse updateTask(Long id, TaskRequest request);
    TaskResponse markTaskAsCompleted(Long id);
    void deleteTask(Long id);
}
