package com.consulteer.facebook.controller;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.service.CommentService;
import com.consulteer.facebook.service.PostService;
import com.consulteer.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @PostMapping("/posts/{postId}/{userId}")
    public ResponseEntity<Comment> commentPost(@PathVariable("postId") Long postId, @PathVariable("userId") Long userId, @RequestBody Comment comment) {
        if (comment != null) {
            return ResponseEntity.ok(commentService.commentPost(postId, userId, comment));
        }
        return ResponseEntity.ok().build();
    }
}
