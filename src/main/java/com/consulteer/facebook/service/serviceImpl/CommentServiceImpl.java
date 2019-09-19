package com.consulteer.facebook.service.serviceImpl;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.CommentRepository;
import com.consulteer.facebook.repository.PostRepository;
import com.consulteer.facebook.repository.UserRepository;
import com.consulteer.facebook.service.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Comment commentPost(Long postId, Long userId, Comment comment) {

        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalPost.isPresent() && optionalUser.isPresent()) {

            User user = optionalUser.get();
            Post post = optionalPost.get();

            comment.setPost(post);
            comment.setUser(user);
            comment.setText(comment.getText());
            comment.setTime(LocalDateTime.now());

            post.getComments().add(comment);
            postRepository.save(post);

            user.getComments().add(comment);
            userRepository.save(user);

            return commentRepository.save(comment);
        }
        return null;
    }
}
