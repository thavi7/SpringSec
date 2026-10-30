package com.avi.oauth2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String provider;
    private String providerSubject;

    public User(String name, String email, String provider, String providersubject) {
        this.name=name;
        this.email=email;
        this.provider=provider;
        this.providerSubject=providersubject;
    }
}
