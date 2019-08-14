package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Comment;

import java.time.LocalDateTime;

public class CommentDto {

    private Long id;
    private BasicUserDto user;
    private BasicPostDto post;
    private String text;
    private int count;
    private LocalDateTime time;

    public static CommentDto convert(Comment comment) {
        if (comment != null) {
            CommentDto commentDto = new CommentDto();

            commentDto.setId(comment.getId());
            commentDto.setText(comment.getText());
            commentDto.setCount(comment.getCount());
            commentDto.setTime(comment.getTime());

            if (comment.getUser() != null) {

                BasicUserDto basicUserDto = new BasicUserDto();

                basicUserDto.setId(comment.getUser().getId());
                basicUserDto.setName(comment.getUser().getName());
                basicUserDto.setLastName(comment.getUser().getLastName());
                basicUserDto.setEmail(comment.getUser().getEmail());
                basicUserDto.setBirthdate(comment.getUser().getBirthdate());
                basicUserDto.setPassword(comment.getUser().getPassword());

                commentDto.setUser(basicUserDto);
            }

            if (comment.getPost() != null) {

                BasicPostDto basicPostDto = new BasicPostDto();

                basicPostDto.setId(comment.getPost().getId());
                basicPostDto.setTitle(comment.getPost().getTitle());
                basicPostDto.setText(comment.getPost().getText());
                basicPostDto.setCount(comment.getPost().getCount());
                basicPostDto.setTime(comment.getPost().getTime());

                commentDto.setPost(basicPostDto);
            }

            return commentDto;
        }

        return null;
    }

    public BasicUserDto getUser() {
        return user;
    }

    public void setUser(BasicUserDto user) {
        this.user = user;
    }

    public BasicPostDto getPost() {
        return post;
    }

    public void setPost(BasicPostDto post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
