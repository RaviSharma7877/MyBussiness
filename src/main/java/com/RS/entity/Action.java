package com.RS.entity;

import java.time.LocalDateTime;

import com.RS.enums.ActionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actions")
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @NotNull
    private ActionType type;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @NotNull
    private String automationId;

    private int order;

    @NotNull
    private String laneId = "0";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "automationId", referencedColumnName = "id", insertable = false, updatable = false)
    private Automations automation;

    // Other fields and relationships
}
