package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Automations {

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
    private String triggerId;

    @NotNull
    @Column(nullable = false)
    private Boolean published = false;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String subAccountId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "triggerId", referencedColumnName = "id", insertable = false, updatable = false)
    private Trigger trigger;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subAccountId", referencedColumnName = "id", insertable = false, updatable = false)
    private SubAccount subAccount;

    @OneToMany(mappedBy = "automation", cascade = CascadeType.ALL)
    private List<Action> actions;

    @OneToMany(mappedBy = "automation", cascade = CascadeType.ALL)
    private List<AutomationInstance> automationInstances;

    // Other fields and relationships
}
