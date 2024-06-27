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
@Table(name = "addons")
public class AddOns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Boolean active = false;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String priceId;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String agencyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Agency agency;

    // Other fields and relationships
}
