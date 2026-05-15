package com.devamateur.Todo_App.Service;

import com.devamateur.Todo_App.Entity.Task;
import com.devamateur.Todo_App.Exception.AppException;
import com.devamateur.Todo_App.Exception.ErrorCode;
import com.devamateur.Todo_App.Mapper.TaskMapper;
import com.devamateur.Todo_App.Repository.TaskRepository;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;

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

    @Override
    public TaskResponse getTaskById(Long id) {
        Task task = getTaskEntityById(id);
        return taskMapper.toTaskResponse(task);
    }

    @Override
    public TaskResponse createTask(TaskRequest request) {
        Task task = taskMapper.toTask(request);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Override
    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task task = getTaskEntityById(id);
        taskMapper.updateEntityFromRequest(request, task);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

    @Override
    public TaskResponse markTaskAsCompleted(Long id) {
        Task task = getTaskEntityById(id);
        task.setCompleted(true);
        return taskMapper.toTaskResponse(taskRepository.save(task));
    }

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
