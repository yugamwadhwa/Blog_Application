package com.example.blogappapis.repositories;

import com.example.blogappapis.entities.Category;
import com.example.blogappapis.entities.Post;
import com.example.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo  extends JpaRepository<Post,Integer> {
    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
