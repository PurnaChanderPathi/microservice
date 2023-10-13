package com.ppc.user.servcie.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "micro_users")
public class User {
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME",length = 20)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;
    // other user properties that you want
    @Transient
    private List<Rating> ratings=new ArrayList<>();
}
