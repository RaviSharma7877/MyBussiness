package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String pipelineId;

    @NotNull
    @Column(nullable = false)
    private int order = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pipelineId", referencedColumnName = "id", insertable = false, updatable = false)
    private Pipeline pipeline;

    @OneToMany(mappedBy = "lane", cascade = CascadeType.ALL)
    private List<Ticket> tickets;
}
