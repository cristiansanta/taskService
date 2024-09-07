package com.mindhub.taskservice.controller;

import com.mindhub.taskservice.dtos.TaskDTO;
import com.mindhub.taskservice.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Mono<TaskDTO> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping
    public Flux<TaskDTO> getAllTasks() {
        return taskService.getAllTasks().delayElements(Duration.ofSeconds(2));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    public Mono<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteTask(@PathVariable Long id) {
        return taskService.deleteTask(id);
    }

    @GetMapping("/user/{email}")
    public Flux<TaskDTO> getTasksByUserEmail(@PathVariable String email){
        return taskService.retrieveTasksByUserEmail(email).delayElements(Duration.ofSeconds(1));
    }
}