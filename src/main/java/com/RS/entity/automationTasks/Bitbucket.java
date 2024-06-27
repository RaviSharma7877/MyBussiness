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
public class Bitbucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String accessToken;
    private String refreshToken;
    private String repositoryId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "bitbucket", cascade = CascadeType.ALL)
    private List<Connections> connections;
}
