package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Post;

import java.time.LocalDateTime;

public class BasicPostDto {

    private Long id;
    private String title = "Default";
    private String text;
    private int count;
    private LocalDateTime time;

    public static BasicPostDto convert(Post post) {
        if (post != null) {
            BasicPostDto basicPostDto = new BasicPostDto();

            basicPostDto.setId(post.getId());
            basicPostDto.setCount(post.getCount());
            basicPostDto.setText(post.getText());
            basicPostDto.setTime(post.getTime());
            basicPostDto.setTitle(post.getTitle());

            return basicPostDto;
        }

        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
