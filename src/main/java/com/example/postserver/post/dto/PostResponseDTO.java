package com.example.postserver.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponseDTO {
    private long id;
    private String title;
    private String content;
    private long view;
    private long like;
    private String author;
}
