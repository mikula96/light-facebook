package com.consulteer.facebook.service;


import com.consulteer.facebook.entity.Comment;

public interface CommentService {
    Comment commentPost(Long postId, Long userId, Comment comment);
}
