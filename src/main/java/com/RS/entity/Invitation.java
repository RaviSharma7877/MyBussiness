package com.RS.entity;

import com.RS.enums.InvitationStatus;
import com.RS.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String email;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false)
    private String agencyId;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InvitationStatus status = InvitationStatus.PENDING;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.SUBACCOUNT_USER;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "agencyId", referencedColumnName = "id", insertable = false, updatable = false)
    private Agency agency;
}
	