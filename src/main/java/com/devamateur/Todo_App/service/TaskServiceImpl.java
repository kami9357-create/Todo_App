package com.devamateur.Todo_App.service;

import com.devamateur.Todo_App.entity.Task;
import com.devamateur.Todo_App.exception.AppException;
import com.devamateur.Todo_App.exception.ErrorCode;
import com.devamateur.Todo_App.mapper.TaskMapper;
import com.devamateur.Todo_App.repository.TaskRepository;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;

    @Transactional(readOnly = true)
    @Override
    public List<TaskResponse> getTasks(Boolean completed) {
        List<Task> tasks;
        if (completed != null) {
            tasks = taskRepository.findByCompleted(completed);
        } else {
            tasks = taskRepository.findAll();
        }
        return taskMapper.toTaskResponseList(tasks);
    }

    @Transactional(readOnly = true)
    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = getTaskEntityById(id);
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public List<TaskResponse> searchTasks(String keyword) {

        if (keyword == null || keyword.trim().isEmpty()) {
            throw new AppException(ErrorCode.INVALID_REQUEST);
        }

        List<Task> task = taskRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(keyword, keyword);
        return taskMapper.toTaskResponseList(task);
    }


    @Transactional
    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toTask(request);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Transactional
    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = getTaskEntityById(id);
        taskMapper.updateEntityFromRequest(request, task);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Transactional
    @Override
    public TaskResponse markTaskAsCompleted(Long id) {
        Task task = getTaskEntityById(id);
        task.setCompleted(true);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Transactional
    @Override
    public TaskResponse markTaskAsUncompleted(Long id) {
        Task task = getTaskEntityById(id);
        task.setCompleted(false);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }


    @Transactional
    @Override
    public void deleteTask(Long id) {
        Task task = getTaskEntityById(id);
        taskRepository.delete(task);
    }

    private Task getTaskEntityById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.TASK_NOT_FOUND));
    }
}
