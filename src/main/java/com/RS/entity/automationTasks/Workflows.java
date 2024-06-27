package com.RS.entity.automationTasks;

import java.time.LocalDateTime;
import java.util.List;

import com.RS.entity.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workflows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nodes;
    private String edges;
    private String name;
    private String discordTemplate;
    private String notionTemplate;
    private String slackTemplate;
    private String[] slackChannels;
    private String slackAccessToken;
    private String notionAccessToken;
    private String notionDbId;
    private String flowPath;
    private String cronPath;
    private Boolean publish = false;
    private String description;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;
    private String userId;

    
}
