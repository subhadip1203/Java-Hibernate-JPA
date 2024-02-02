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
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int course_id;

    private String courseName;

    private String description;

    //consider Course as owner
    @ManyToMany
    @JoinTable(
            name="authors_courses",
            joinColumns = {
                    @JoinColumn(name= "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name= "author_id")
            }
    )
    @Builder.Default
    private List<Author> authors = new ArrayList<>();

    //consider Course as owner
    @OneToMany(mappedBy = "course")
    @Builder.Default
    private List <Section> sections = new ArrayList<>();
}
