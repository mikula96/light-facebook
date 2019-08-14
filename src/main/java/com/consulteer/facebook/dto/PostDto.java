package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDto {

    private Long id;
    private BasicUserDto user;
    private String title = "Default";
    private String text;
    private List<BasicCommentDto> comments = new ArrayList<>();
    private int count;
    private LocalDateTime time;

    public static PostDto convert(Post post) {
        if (post != null) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setText(post.getText());
            postDto.setTime(post.getTime());
            postDto.setCount(post.getCount());

            if (post.getUser() != null) {

                BasicUserDto basicUserDto = new BasicUserDto();

                basicUserDto.setId(post.getUser().getId());
                basicUserDto.setName(post.getUser().getName());
                basicUserDto.setLastName(post.getUser().getLastName());
                basicUserDto.setBirthdate(post.getUser().getBirthdate());
                basicUserDto.setEmail(post.getUser().getEmail());
                basicUserDto.setPassword(post.getUser().getPassword());

                postDto.setUser(basicUserDto);
            }

            if (!post.getComments().isEmpty()) {
                BasicCommentDto basicCommentDto = new BasicCommentDto();
                for(int i = 0; i < post.getComments().size(); i++){
                    postDto.getComments().add(basicCommentDto);
                }
            }
        }
        return null;
    }

    public List<BasicCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<BasicCommentDto> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BasicUserDto getUser() {
        return user;
    }

    public void setUser(BasicUserDto user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
