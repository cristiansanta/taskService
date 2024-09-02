package com.mindhub.taskservice.mappers;

import com.mindhub.taskservice.dtos.TaskDTO;
import com.mindhub.taskservice.entities.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getUserId()
        );
    }

    public static Task toEntity(TaskDTO dto) {
        return new Task(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getUserId()
        );
    }
}