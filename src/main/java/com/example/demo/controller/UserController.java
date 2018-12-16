package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }
    @RequestMapping(path = "g", method = RequestMethod.GET)
    public UserDto getUser(HttpServletRequest request, @RequestParam("q") String q) {
        System.out.println(q);
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }


}
