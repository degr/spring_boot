package com.example.demo.entity;

import com.example.demo.dto.UserDto;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Data
public class User extends AbstractPersistable<Integer> {

    private String name;

    public User() {
    }

    public User (UserDto userDto) {
        setId(userDto.getId());
        setName(userDto.getName());
    }


}
