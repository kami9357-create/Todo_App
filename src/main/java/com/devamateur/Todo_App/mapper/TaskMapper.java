package com.devamateur.Todo_App.mapper;

import com.devamateur.Todo_App.entity.Task;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskRequest taskRequest);

    TaskResponse toTaskResponse(Task task);

    void updateEntityFromRequest(TaskRequest request, @MappingTarget Task task);

    List<TaskResponse> toTaskResponseList(List<Task> tasks);
}
