/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.UserEntity;
import com.ptit.stu.entity.dto.UserDTO;
import com.ptit.stu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dovan
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public UserDTO viewUser(@RequestParam("id") Integer id) {
        UserEntity u = userService.findById(id).get();
        return UserDTO.convertToUserDTO(u);
    }

    @PostMapping("")
    public UserDTO createUser(@RequestBody UserDTO user) {
        UserEntity u = new UserEntity();
        u = UserDTO.convertToUserEntity(user);
        userService.save(u);
        user = UserDTO.convertToUserDTO(u);
        return user;
    }

    @PutMapping("")
    public UserDTO updateUser(@RequestBody UserDTO user) {
        UserEntity u = new UserEntity();
        u = UserDTO.convertToUserEntity(user);
        userService.save(u);
        user = UserDTO.convertToUserDTO(u);
        return user;
    }
}
