package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Comment;

import java.time.LocalDateTime;

public class BasicCommentDto {

    private Long id;
    private String text;
    private int count;
    private LocalDateTime time;

    public static BasicCommentDto convert(Comment comment) {
        if (comment != null) {
            BasicCommentDto basicCommentDto = new BasicCommentDto();

            basicCommentDto.setId(comment.getId());
            basicCommentDto.setText(comment.getText());
            basicCommentDto.setTime(comment.getTime());
            basicCommentDto.setCount(comment.getCount());
/*            if (comment.getUser() != null) {

                BasicUserDto basicUserDto = new BasicUserDto();

                basicUserDto.setId(comment.getUser().getId());
                basicUserDto.setName(comment.getUser().getName());
                basicUserDto.setLastName(comment.getUser().getLastName());
                basicUserDto.setBirthdate(comment.getUser().getBirthdate());
                basicUserDto.setEmail(comment.getUser().getEmail());
                basicUserDto.setPassword(comment.getUser().getPassword());

                basicCommentDto.setUser(basicUserDto);
            }

            if (comment.getPost() != null) {

                BasicPostDto basicPostDto = new BasicPostDto();

                basicPostDto.setId(comment.getPost().getId());
                basicPostDto.setTitle(comment.getPost().getTitle());
                basicPostDto.setText(comment.getPost().getText());
                basicPostDto.setTime(comment.getPost().getTime());
                basicPostDto.setCount(comment.getPost().getCount());

                basicCommentDto.setPost(basicPostDto);

            }*/

            return basicCommentDto;
        }

        return null;
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