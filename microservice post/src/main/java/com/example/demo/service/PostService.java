package com.example.demo.service;

import com.example.demo.Config.RestTempleteConfig;
import com.example.demo.Dto.PostDto;
import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    RestTempleteConfig restTemplate;

    public Post savePost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post save = postRepository.save((post));
        return  save; }

    public Post getPostById(String postId){
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();
        return post;
    }

    public PostDto getPostWithComments(String postId){
        Post post = postRepository.findById(postId).get();
        ArrayList allComments = restTemplate.restTemplate().getForObject
                ("http://COMMENT-SERVICE/api/comments/" + postId,ArrayList.class);
        PostDto postWithComments = new PostDto();
        postWithComments.setId(post.getId());
        postWithComments.setTitle(post.getTitle());
        postWithComments.setContent(post.getContent());
        postWithComments.setDescription(post.getDescription());
        postWithComments.setComments(allComments);
        return postWithComments;
    }
}
