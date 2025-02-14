package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    private CommentService commentService;
        //http://localhost:8082/api/comments/saveComment
    @PostMapping("saveComment")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
        Comment savedComment = commentService.saveComment(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  List<Comment> getComment(@PathVariable String id){
        List<Comment> comments = commentService.getAllCommentOfPostId(id);
        return comments;
    }
}



