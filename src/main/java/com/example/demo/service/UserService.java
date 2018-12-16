package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;


@Service
@Scope("singleton")
public class UserService {

    private UserDao userDao;


    @PostConstruct
    public void c() {
        System.out.println("hello");
    }
    public UserService(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("not empty const");
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
