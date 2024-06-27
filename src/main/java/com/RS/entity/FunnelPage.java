package com.RS.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FunnelPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name;

    @Size(max = 255)
    private String pathName = "";

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @NotNull
    @Column(nullable = false)
    private int visits = 0;

    @NotNull
    @Size(max = 65535)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @NotNull
    @Column(nullable = false)
    private int order;

    @Size(max = 255)
    private String previewImage;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String funnelId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funnelId", referencedColumnName = "id", insertable = false, updatable = false)
    private Funnel funnel;
}
