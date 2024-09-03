package com.mindhub.taskservice.mappers;

import com.mindhub.taskservice.dtos.TaskDTO;
import com.mindhub.taskservice.entities.TaskEntity;

public class TaskMapper {

    public static TaskDTO toDTO(TaskEntity task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getUserEmail()
        );
    }

    public static TaskEntity toEntity(TaskDTO dto) {
        return new TaskEntity(
                dto.getId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus(),
                dto.getUserEmail()
        );
    }
}