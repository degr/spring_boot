package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDto createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        User savedUser = userDao.save(user);
        return new UserDto(savedUser);
    }

    public UserDto findById(Integer id) {
        Optional<User> user = userDao.findById(id);
        return user.map(UserDto::new).orElse(null);
    }
}
