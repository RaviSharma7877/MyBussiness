package com.RS.entity.automationTasks.Bot;

import java.time.LocalDateTime;
import java.util.List;

import com.RS.entity.Users;
import com.RS.entity.automationTasks.Connections;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class SlackBot {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	private String accessToken;
	private String botToken;
	private String botUserId;
	private String botName;
	private String userId;
	@ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "slackBotId", cascade = CascadeType.ALL)
    private List<Connections> connections;
}
