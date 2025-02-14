package com.example.demo.controller;

import com.example.demo.Config.RestTempleteConfig;
import com.example.demo.Dto.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostService postService;


    @GetMapping ("{postId}")
        public ResponseEntity<Post> getPostByPostId(@PathVariable String postId){
        Post postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById,HttpStatus.ACCEPTED);

    }

    @PostMapping("posting")
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        Post saved = postService.savePost(post);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

//    http://localhost:8082/api/posts/postAndComment/
    @GetMapping("postAndComment/{postId}")
    public ResponseEntity<PostDto> getPostWithComments(@PathVariable String postId ){
        PostDto postDto = postService.getPostWithComments(postId);
        return new ResponseEntity<>(postDto , HttpStatus.CREATED);
    }

}
