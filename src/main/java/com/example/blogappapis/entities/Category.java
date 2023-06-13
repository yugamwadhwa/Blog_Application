package com.example.blogappapis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name="title",length = 100,nullable = false)
    private String categoryTitle;

    @Column(name="description")
    private String CategoryDescription;

    @OneToMany(mappedBy="category",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Post> posts= new ArrayList<>();

}
