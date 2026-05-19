package com.devamateur.Todo_App.Mapper;

import com.devamateur.Todo_App.Entity.Task;
import com.devamateur.Todo_App.dto.request.TaskRequest;
import com.devamateur.Todo_App.dto.response.TaskResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toTask(TaskRequest taskRequest);

    TaskResponse toTaskResponse(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE) //
    void updateEntityFromRequest(TaskRequest request, @MappingTarget Task task);

    List<TaskResponse> toTaskResponseList(List<Task> tasks);
}
