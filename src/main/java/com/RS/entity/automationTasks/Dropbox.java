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
public class Dropbox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String accessToken;
    private String refreshToken;
    private String folderId;
    private String user_Id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "dropboxId", cascade = CascadeType.ALL)
    private List<Connections> connections;
}
