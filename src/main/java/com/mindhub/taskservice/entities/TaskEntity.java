package com.mindhub.taskservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("tasks")
public class TaskEntity {
    @Id
    private Long id;
    private String title;
    private String description;
    private String status;
    private String userEmail;
}