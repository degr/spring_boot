package com.example.demo.controller;

import com.example.demo.dao.ChatDao;
import com.example.demo.dao.MessageDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Chat;
import com.example.demo.entity.Message;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final ChatDao chatDao;
    private final MessageDao messageDao;
    private final UserDao userDao;

    public UserController(UserService userService, ChatDao chatDao, MessageDao messageDao, UserDao userDao) {
        this.userService = userService;
        this.chatDao = chatDao;
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }


    @RequestMapping(path = "test", method = RequestMethod.GET)
    public String test() {
        UserDto userDto1 = new UserDto();
        userDto1.setName("user_1");
        userDto1 = userService.createUser(userDto1);

        UserDto userDto2 = new UserDto();
        userDto2.setName("user_2");
        userService.createUser(userDto2);

        List<User> users = userService.findAll();
        Chat chat = new Chat();
        chat.setChatName("my chat");
        chat.setUsers(new ArrayList<>());
        chat.getUsers().addAll(users);
        users.forEach(user -> {
            if(user.getChats() == null) {
                user.setChats(new ArrayList<>());
            }
            user.getChats().add(chat);
        });
        chatDao.save(chat);


        Message message = new Message();
        message.setMessage("Hello!");
        message.setChat(chat);
        if(chat.getMessages() == null) {
            chat.setMessages(new ArrayList<>());
        }
        chat.getMessages().add(message);
        User user1 = userDao.findById(userDto1.getId()).get();
        if(user1.getMessages() == null) {
            user1.setMessages(new ArrayList<>());
        }
        user1.getMessages().add(message);
        message.setUser(user1);

        messageDao.save(message);

        return  "ok";
    }
}
