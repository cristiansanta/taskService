package com.mindhub.taskservice.repositories;

import com.mindhub.taskservice.entities.TaskEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TaskRepository extends ReactiveCrudRepository<TaskEntity, Long> {

}