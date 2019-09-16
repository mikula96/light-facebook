package com.consulteer.facebook.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>(0);
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>(0);
}
