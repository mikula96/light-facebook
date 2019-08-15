package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.PostRepository;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public int likePost(Post post) {
        int count = post.getCount();
        count++;
        post.setCount(count);
        postRepository.save(post);
        return count;
    }

    @Override
    public int likePost(long postId) {
        Post post = postRepository.getOne(postId);
        if (post != null) {
            return likePost(post);
        }
        return 0;
    }

    @Override
    public Post create(Long userId, Post post) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            post.setUser(user);
            post.setTime(LocalDateTime.now());
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public Page<Post> findAllPageable(Long userId, int page, int size, boolean sort) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            if (sort) {
                return postRepository.findAllByUserSorted(optionalUser.get(), PageRequest.of(page, size));
            }
            return postRepository.findAllByUser(optionalUser.get(), PageRequest.of(page, size));
        }
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Page<Post> findAllByUserIdAndYear(Long userId, int year, int page, int size) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            return postRepository.findAllByUserAndYear(optionalUser.get(), year, PageRequest.of(page, size));
        }
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Post updatePost(Long id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            optionalPost.get().setTitle(post.getTitle());
            optionalPost.get().setText(post.getText());
            return postRepository.save(optionalPost.get());
        }
        return null;
    }

    @Override
    public void deletePostsByUserId(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            List<Post> listOfPosts = postRepository.findAllPostsByUser(optionalUser.get());
            for (Post p : listOfPosts) {
                postRepository.delete(p);
            }
        }
    }

}