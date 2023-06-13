package com.example.blogappapis.controllers;

import com.example.blogappapis.entities.Post;
import com.example.blogappapis.payloads.PostDto;
import com.example.blogappapis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,@PathVariable Integer categoryId){
        PostDto createPost=this.postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    // get by user
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId){
        List<PostDto> posts=this.postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, OK);
    }

    // get by category

    @GetMapping("/category/{categoryId}/posts")
    // get by user
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDto> posts=this.postService.getPostByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, OK);
    }

    // get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        List<PostDto> allPost=this.postService.getAllPost();
        return new ResponseEntity<List<PostDto>>(allPost,OK);
    }
    // get post by id

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postDto=this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
    }

    // delete post
    @DeleteMapping("/posts/{postId}")
    public void deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);

    }
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
        PostDto updatePost=this.postService.updatePost(postDto,postId);
        return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
    }
}
