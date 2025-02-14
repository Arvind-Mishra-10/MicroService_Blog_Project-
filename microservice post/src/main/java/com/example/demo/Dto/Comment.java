package com.example.demo.Dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String commentId;
    private String name;
    private String email;
    private String body;
    private String id;
}
