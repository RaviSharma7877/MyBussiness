package com.RS.entity.automationTasks;

import java.time.LocalDateTime;
import java.util.List;

import com.RS.entity.Users;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscordWebhook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String webhookId;
    private String url;
    private String name;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private String guildName;
    private String guildId;
    private String channelId;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "discordWebhook", cascade = CascadeType.ALL)
    private List<Connections> connections;
}
