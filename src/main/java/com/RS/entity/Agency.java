package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String connectAccountId = "";

    @NotNull
    @Size(max = 255)
    @Column(nullable = false)
    private String customerId = "";

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name;

    @Lob
    @Size(max = 65535)
    private String agencyLogo;

    @Lob
    @Email
    @Size(max = 65535)
    private String companyEmail;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false)
    private String companyPhone;

    @NotNull
    @Column(nullable = false)
    private Boolean whiteLabel = true;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String address;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String city;

    @NotNull
    @Size(min = 1, max = 10)
    @Column(nullable = false)
    private String zipCode;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String state;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String country;

    @NotNull
    @Column(nullable = false)
    private Integer goal = 5;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Users> users;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<SubAccount> subAccounts;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<AgencySidebarOption> sidebarOptions;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Invitation> invitations;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL)
    private List<AddOns> addOns;

    // Ensure to add Subscription entity if Subscription is a standalone entity

    // Other fields and relationships
}
