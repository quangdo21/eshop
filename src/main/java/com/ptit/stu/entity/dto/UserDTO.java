/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.UserEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dovan
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private Integer id;
    private String name;
    private boolean gender;
    private Date birth;
    private String address;
    private String phone;
    private String email;

    public static UserDTO convertToUserDTO(UserEntity user) {
        UserDTO u = new UserDTO();
        if (user.getId() != null) {
            u.setId(user.getId());
        }
        u.setName(user.getName());
        u.setAddress(user.getAddress());
        u.setGender(user.isGender());
        u.setBirth(user.getBirth());
        u.setPhone(user.getPhone());
        u.setEmail(user.getEmail());
        return u;
    }

    public static UserEntity convertToUserEntity(UserDTO user) {
        UserEntity u = new UserEntity();
        if (user.getId() != null) {
            u.setId(user.getId());
        }
        u.setName(user.getName());
        u.setAddress(user.getAddress());
        u.setGender(user.isGender());
        u.setBirth(user.getBirth());
        u.setPhone(user.getPhone());
        u.setEmail(user.getEmail());
        return u;
    }
}
