package com.RS.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
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
@Table(name = "activity_tracker")
public class ActivityTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime loginTime;

    @Column
    private LocalDateTime logoutTime;

    @NotNull
    @Column(nullable = false)
    private Long productiveTime; // in minutes or seconds

    @NotNull
    @Column(nullable = false)
    private Long nonProductiveTime; // in minutes or seconds

    @NotNull
    @Column(nullable = false)
    private Long idleTime; // in minutes or seconds

    @NotNull
    @Column(nullable = false)
    private Long activeTime; // in minutes or seconds

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    // Additional methods if needed
}
