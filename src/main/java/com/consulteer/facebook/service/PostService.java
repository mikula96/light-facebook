package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Post;
import org.springframework.data.domain.Page;


public interface PostService {

    int likePost(Post post);

    int likePost(long postId);

    Post create(Long userId, Post post);

    Page<Post> findAllPageable(Long userId, int page, int size, boolean sort);

    Page<Post> findAllByUserIdAndYear(Long userId, int year, int page, int size);

    Post updatePost(Long id, Post post);

    void deletePostsByUserId(Long userId);

}
