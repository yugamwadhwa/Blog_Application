package com.example.blogappapis.payloads;

import com.example.blogappapis.entities.Category;
import com.example.blogappapis.entities.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
    private  Integer PostId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;

    private CategoryDto category;
    private UserDto user;

    private Set<Comment> comments= new HashSet<>();
}
