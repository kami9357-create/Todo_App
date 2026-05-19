package com.devamateur.Todo_App.dto.response;

import com.devamateur.Todo_App.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class TaskResponse {
    Long id;

    String title;

    String description;

    Boolean completed;

    LocalDateTime dueDate;

    Priority priority;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
