package com.mindhub.taskservice.repositories;

import com.mindhub.taskservice.entities.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TaskRepository extends ReactiveCrudRepository<Task, Long> {
    Flux<Task> findByUserId(Long userId);
}