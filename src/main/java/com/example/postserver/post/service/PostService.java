package com.example.postserver.post.service;

import com.example.postserver.post.dto.CreatePostRequestDTO;
import com.example.postserver.post.dto.PostResponseDTO;
import com.example.postserver.post.entity.PostEntity;
import com.example.postserver.post.repository.PostRepository;
import com.example.postserver.user.entity.UserEntity;
import com.example.postserver.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostResponseDTO createPost(CreatePostRequestDTO request, Long userId) {
        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No User"));

        PostEntity post = PostEntity.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .viewCount(0)
                .likeCount(0)
                .user(user)
                .build();

        post = postRepository.save(post);

        return PostResponseDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .view(post.getViewCount())
                .like(post.getLikeCount())
                .author(post.getUser().getName()) // UserEntity에 getUsername()이 있다고 가정
                .build();
    }
}
