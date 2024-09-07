package com.mindhub.taskservice.repositories;

import com.mindhub.taskservice.entities.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Long> {
    Flux<TaskEntity> findTasksByUserEmail(String email);

    <T> Optional<T> findByUserEmail(String email);
}