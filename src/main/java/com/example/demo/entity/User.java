package com.example.demo.entity;

import com.example.demo.dto.UserDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
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
