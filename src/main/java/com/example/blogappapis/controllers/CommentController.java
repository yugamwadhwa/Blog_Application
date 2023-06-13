package com.example.blogappapis.controllers;

import com.example.blogappapis.entities.Comment;
import com.example.blogappapis.payloads.ApiResponse;
import com.example.blogappapis.payloads.CommentDto;
import com.example.blogappapis.payloads.PostDto;
import com.example.blogappapis.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){
        CommentDto createComment=this.commentService.createComment(comment,postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("COMMENT deleted success",true),HttpStatus.OK);
    }

}
