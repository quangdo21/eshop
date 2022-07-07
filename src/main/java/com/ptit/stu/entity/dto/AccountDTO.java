/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.AccountEntity;
import com.ptit.stu.entity.UserEntity;
import com.ptit.stu.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dovan
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDTO {

    @Autowired
    UserService userService;

    private String username;
    private String password;
    private Integer user;

    public AccountEntity convertToAccountEntity(AccountDTO account) {
        AccountEntity a = new AccountEntity();
        if (account.getUsername() != null) {
            a.setUsername(account.getUsername());
        }
        if (account.getPassword() != null) {
            a.setPassword(account.getPassword());
        }
        if (account.getUser() != null) {
            UserEntity u = new UserEntity();
            u.setId(account.getUser());
            a.setUser(u);
        }
        return a;
    }

    public static AccountDTO convertToAccountDTO(AccountEntity account) {
        AccountDTO a = new AccountDTO();
        if (account.getUsername() != null) {
            a.setUsername(account.getUsername());
        }
        if (account.getPassword() != null) {
            a.setPassword(account.getPassword());
        }
        if (account.getUser() != null) {
            a.setUser(account.getUser().getId());
        }
        return a;
    }
}
