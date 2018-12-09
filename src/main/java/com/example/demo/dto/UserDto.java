package com.example.demo.dto;

import com.example.demo.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String name;

    public UserDto() {

    }
    public UserDto(User savedUser) {
        setId(savedUser.getId());
        setName(savedUser.getName());
    }
}
