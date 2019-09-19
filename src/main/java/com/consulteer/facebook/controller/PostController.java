package com.consulteer.facebook.controller;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.service.services.PostService;
import com.consulteer.facebook.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;


    @PutMapping("/{id}/like")
    public Integer likePost(@PathVariable("id") Long id) {
        return postService.likePost(id);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Long postId, @RequestBody Post post) {
        return ResponseEntity.ok(postService.updatePost(postId, post));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Void> deletePostsByUserId(@PathVariable("userId") Long userId) {
        postService.deletePostsByUserId(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/users/{userId}", params = {"year", "page", "size"})
    public ResponseEntity<Page<Post>> findAllByUserAndYear(@PathVariable("userId") Long userId, @RequestParam("year") int year,
                                                           @RequestParam int page, @RequestParam int size) {
        Page<Post> result = postService.findAllByUserIdAndYear(userId, year, page, size);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{userId}/posts", params = {"page", "size", "sort"})
    public ResponseEntity<Page<Post>> findAllPageable(@PathVariable("userId") Long userId, @RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("sort") boolean sort) {
        Page<Post> result = postService.findAllPageable(userId, page, size, sort);
        return ResponseEntity.ok(result);
    }

}
