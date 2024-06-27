package com.RS.entity.automationTasks;

import java.time.LocalDateTime;
import java.util.List;

import com.RS.entity.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalGoogleCredential {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	private String accessToken;
	private String folderId;
	private String pageToken;
	private String channelId;
	private boolean subscribed;
	private String userId;
	@ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;
}
