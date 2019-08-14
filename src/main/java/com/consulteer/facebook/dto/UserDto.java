package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDto {

    private List<BasicCommentDto> comments = new ArrayList<>();
    private List<BasicPostDto> posts = new ArrayList<>();

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String password;

    public static UserDto convert(User user) {

        if (user != null) {
            UserDto userDto = new UserDto();

            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDto.setPassword(user.getPassword());
            userDto.setBirthdate(user.getBirthdate());

            if (!user.getPosts().isEmpty()) {
                BasicPostDto basicPostDto = new BasicPostDto();
                for (int i = 0; i < user.getPosts().size(); i++) {
                    userDto.getPosts().add(basicPostDto);
                }
            }

            if (!user.getComments().isEmpty()) {
                BasicCommentDto basicCommentDto = new BasicCommentDto();
                for (int i = 0; i < user.getComments().size(); i++) {
                    userDto.getComments().add(basicCommentDto);
                }
            }

            return userDto;
        }

        return null;
    }

    public static User convert(UserDto userDto) {
        if (userDto != null) {

            User user = new User();

            user.setName(userDto.getName());
            user.setLastName(userDto.getLastName());
            user.setBirthdate(userDto.getBirthdate());
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());


        }

        return null;
    }

    public List<BasicCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<BasicCommentDto> comments) {
        this.comments = comments;
    }

    public List<BasicPostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<BasicPostDto> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}