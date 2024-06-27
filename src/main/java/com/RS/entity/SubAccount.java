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
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String connectAccountId = "";

    @Column(length = 255, nullable = false)
    private String name;

    // Use @Lob annotation for large texts
    private String subAccountLogo;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    // Use @Lob annotation for large texts
    @Column(length = 255)
    @Email
    private String companyEmail;

    private String companyPhone;
    private int goal = 5;
    private String address;
    private String city;
    private String zipCode;
    private String state;
    private String country;
    
    private String agencyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Agency agency;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<SubAccountSidebarOption> sidebarOptions;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Permissions> permissions;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Funnel> funnels;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Media> media;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Trigger> triggers;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Automations> automations;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Pipeline> pipelines;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Tag> tags;

    @OneToMany(mappedBy = "subAccount", cascade = CascadeType.ALL)
    private List<Notification> notifications;

    // Other fields and relationships
}
