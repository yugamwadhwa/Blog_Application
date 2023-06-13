package com.example.blogappapis.services.impl;

import com.example.blogappapis.entities.Comment;
import com.example.blogappapis.entities.Post;
import com.example.blogappapis.exceptions.ResourceNotFoundException;
import com.example.blogappapis.payloads.CommentDto;
import com.example.blogappapis.repositories.CommentRepo;
import com.example.blogappapis.repositories.PostRepo;
import com.example.blogappapis.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post=this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","post id",postId));
        Comment comment=this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment=this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com=this.commentRepo.findById(commentId).orElseThrow(()->new ResourceNotFoundException("Comment","CommentId",commentId));
        this.commentRepo.delete(com);
    }
}
