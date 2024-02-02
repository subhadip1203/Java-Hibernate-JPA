package com.subhadip.hibernatejpa1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int author_id;

    private String name;


    private String email;

    private int age;

   //consider Author as inverse-owner
    @ManyToMany(mappedBy = "authors")
    @Builder.Default
    private List <Course> courses = new ArrayList<>();

}
