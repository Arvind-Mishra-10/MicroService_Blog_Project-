package com.example.demo.repository;

import com.example.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Comment_Repo extends JpaRepository<Comment,String> {
    List<Comment> findByid(String id);
}
