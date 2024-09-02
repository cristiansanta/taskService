package com.mindhub.taskservice.services.impl;

import com.mindhub.taskservice.dtos.TaskDTO;
import com.mindhub.taskservice.entities.Task;
import com.mindhub.taskservice.handlers.NotFoundTask;
import com.mindhub.taskservice.mappers.TaskMapper;
import com.mindhub.taskservice.repositories.TaskRepository;
import com.mindhub.taskservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Mono<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(TaskMapper::toDTO)
                .switchIfEmpty(Mono.error(new NotFoundTask("Task not found with id: " + id)));
    }

    @Override
    public Flux<TaskDTO> getAllTasks() {
        return taskRepository.findAll().map(TaskMapper::toDTO);
    }

    @Override
    public Flux<TaskDTO> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId).map(TaskMapper::toDTO);
    }

    @Override
    public Mono<TaskDTO> createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toEntity(taskDTO);
        return taskRepository.save(task).map(TaskMapper::toDTO);
    }

    @Override
    public Mono<TaskDTO> updateTask(Long id, TaskDTO taskDTO) {
        return taskRepository.findById(id)
                .flatMap(existingTask -> {
                    existingTask.setTitle(taskDTO.getTitle());
                    existingTask.setDescription(taskDTO.getDescription());
                    existingTask.setStatus(taskDTO.getStatus());
                    existingTask.setUserId(taskDTO.getUserId());
                    return taskRepository.save(existingTask);
                })
                .map(TaskMapper::toDTO)
                .switchIfEmpty(Mono.error(new NotFoundTask("Task not found with id: " + id)));
    }

    @Override
    public Mono<Void> deleteTask(Long id) {
        return taskRepository.findById(id)
                .flatMap(task -> taskRepository.delete(task))
                .switchIfEmpty(Mono.error(new NotFoundTask("Task not found with id: " + id)));
    }
}