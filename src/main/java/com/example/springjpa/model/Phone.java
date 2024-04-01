package com.example.springjpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(schema = "T_PHONE")
public class Phone extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PHONE", nullable = false, foreignKey = @ForeignKey(name = "fk_profile_phone"))
    private UserProfile userProfile;
}
