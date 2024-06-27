package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @NotBlank
    @Size(max = 255)
    private String name;
    
    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @NotNull
    private LocalDateTime updatedAt;
    
    private String laneId;
    private int order;
    
    @ManyToOne
    @JoinColumn(name = "laneId", referencedColumnName = "id",insertable = false, updatable = false)
    private Lane lane;
    
    private double value;
    
    @NotBlank
    @Size(max = 255)
    private String description;
    
    @OneToMany
    private List<Tag> tags;
    
    private String customer_Id;
    
    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact customer;
    
    private String assignedUserId;
    
    @ManyToOne
    private Users assigned;
    
    @NotBlank
    @Size(max = 255)
    private String issueKey;           // Unique identifier for the ticket
    
    @NotBlank
    @Size(max = 255)
    private String issueType;          // Type of issue (e.g., Bug, Task, Story, Epic)
    
    @NotBlank
    @Size(max = 255)
    private String project;            // Project to which the ticket belongs
    
    @NotBlank
    @Size(max = 255)
    private String status;             // Current status of the ticket
    
    @NotBlank
    @Size(max = 255)
    private String priority;           // Urgency or importance of the ticket
    
    @NotBlank
    @Size(max = 255)
    private String reporter;           // Person who created the ticket
    
    @NotBlank
    @Size(max = 255)
    private String labels;             // Tags or keywords associated with the ticket
    
    @NotBlank
    @Size(max = 255)
    private String components;         // Parts of the project affected by the ticket
    
    @NotBlank
    @Size(max = 255)
    private String fixVersion;         // Version in which the issue will be resolved
    
    @NotBlank
    @Size(max = 255)
    private String affectedVersions;   // Versions affected by the issue
    
    @NotBlank
    @Size(max = 255)
    private String environment;        // Environment where the issue occurred
    
    private List<String> attachments;  // Files related to the ticket
    
    private List<String> comments;     // Notes and discussions about the ticket
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> subTasks;     // Sub-tasks linked to the main ticket
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> linkedIssues; // Related issues
    
    private LocalDateTime dueDate;     // Due date for resolving the ticket
    
    @NotBlank
    @Size(max = 255)
    private String resolution;         // Outcome of the issue
    
    @NotBlank
    @Size(max = 255)
    private String timeTracking;       // Time spent and estimated time for the task
    
    @NotBlank
    @Size(max = 255)
    private String sprint;             // Sprint to which the ticket is assigned
    
    @NotBlank
    @Size(max = 255)
    private String epicLink;           // Epic to which this ticket belongs
    
    private int storyPoints;           // Effort estimate for the task
}
