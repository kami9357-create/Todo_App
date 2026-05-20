package com.devamateur.Todo_App.mapper;

import com.devamateur.Todo_App.dto.request.TaskPatchRequest;
import com.devamateur.Todo_App.entity.Task;
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

    // Dùng cho PUT: cập nhật toàn bộ, null có thể ghi đè vào entity
    void updateEntityFromRequest(TaskRequest request, @MappingTarget Task task);

    // Dùng cho PATCH: chỉ cập nhật những trường có giá trị khác null, bỏ qua trường null
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void patchEntityFromRequest(TaskPatchRequest request, @MappingTarget Task task);

    List<TaskResponse> toTaskResponseList(List<Task> tasks);
}
