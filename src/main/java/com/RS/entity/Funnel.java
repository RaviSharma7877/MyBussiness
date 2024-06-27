package com.RS.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt;

    @Size(max = 1024)
    private String description;

    @NotNull
    @Column(nullable = false)
    private Boolean published = false;

    @Size(max = 255)
    private String subDomainName;

    @Size(max = 255)
    private String favicon;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String subAccountId;

    @NotNull
    @Column(nullable = false, columnDefinition = "TEXT")
    private String liveProducts = "[]";

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subAccountId", referencedColumnName = "id", insertable = false, updatable = false)
    private SubAccount subAccount;

    @OneToMany(mappedBy = "funnel", cascade = CascadeType.ALL)
    private List<FunnelPage> funnelPages;

    @OneToMany(mappedBy = "funnel", cascade = CascadeType.ALL)
    private List<ClassName> classNames;
}
