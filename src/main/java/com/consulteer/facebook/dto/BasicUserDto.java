package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.User;

import java.time.LocalDate;

public class BasicUserDto {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String password;

    public static BasicUserDto convert(User user) {

        if (user != null) {
            BasicUserDto basicUserDto = new BasicUserDto();

            basicUserDto.setId(user.getId());
            basicUserDto.setName(user.getName());
            basicUserDto.setLastName(user.getLastName());
            basicUserDto.setEmail(user.getEmail());
            basicUserDto.setPassword(user.getPassword());
            basicUserDto.setBirthdate(user.getBirthdate());

            return basicUserDto;
        }

        return null;
    }

    public static User convert(BasicUserDto basicUserDto) {
        if (basicUserDto != null) {
            User user = new User();

            user.setName(basicUserDto.getName());
            user.setLastName(basicUserDto.getLastName());
            user.setEmail(basicUserDto.getEmail());
            user.setBirthdate(basicUserDto.getBirthdate());
            user.setPassword(basicUserDto.getPassword());

            return user;
        }

        return null;
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