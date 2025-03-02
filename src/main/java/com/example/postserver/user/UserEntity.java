package com.example.postserver.user;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=50)
    private String name;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;
}
