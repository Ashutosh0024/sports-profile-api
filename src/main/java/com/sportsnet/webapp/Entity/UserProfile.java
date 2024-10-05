package com.sportsnet.webapp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_profile")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String bio;

    private String tagline;

    @Column(name = "profile_photo")
    private String profilePhoto;

}

