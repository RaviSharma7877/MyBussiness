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
public class AgencySidebarOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name = "Menu";

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String link = "#";

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String icon = "info"; // Assuming 'Icon' is of type String for simplicity

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String agencyId;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Agency agency;
}
