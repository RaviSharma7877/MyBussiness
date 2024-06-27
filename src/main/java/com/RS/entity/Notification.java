package com.RS.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    private String notification;

    @NotNull
    private String agencyId;

    @NotNull
    private String subAccountId;

    @NotNull
    private String userId;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Agency agency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subAccountId", referencedColumnName = "id", insertable = false, updatable = false)
    private SubAccount subAccount;
}
