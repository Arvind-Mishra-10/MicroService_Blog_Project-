package com.example.demo.service;

import com.example.demo.Config.RestTempleteConfig;
import com.example.demo.entity.Comment;
import com.example.demo.payload.Post;
import com.example.demo.repository.Comment_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {

    @Autowired
    Comment_Repo commentRepo;
    @Autowired
    private RestTempleteConfig restTemplete;

    public Comment saveComment(Comment comment){
        String commentID = UUID.randomUUID().toString();
        comment.setCommentId(commentID);

        Post post = restTemplete.restTemplate().getForObject
                ("http://POST-SERVICE/api/posts/" + comment.getId(), Post.class);
        if(post!= null){

        Comment comment1 = commentRepo.save(comment);
        return comment1; }
        else {
            return null;
        }
    }

    public List<Comment> getAllCommentOfPostId(String id) {
        List<Comment> Comments = commentRepo.findByid(id);
        return Comments;
    }

}
