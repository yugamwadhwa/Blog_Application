package com.example.blogappapis.services;

import com.example.blogappapis.entities.Post;
import com.example.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {
    // create

    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    // delete
    void deletePost(Integer postId);

    //get all post
    List<PostDto> getAllPost();
    // get single

    PostDto getPostById(Integer postId);
    //get all post by category

    List<PostDto> getPostByCategory(Integer categoryId);

    // get all post by User
    List<PostDto> getPostByUser(Integer userId);
}
