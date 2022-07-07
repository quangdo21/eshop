/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.AccountEntity;
import com.ptit.stu.entity.dto.AccountDTO;
import com.ptit.stu.service.AccountService;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dovan
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("")
    public String getAcount(@RequestBody AccountDTO account) {
        AccountEntity a = accountService.findByUsername(account.getUsername());
        try {
            if (a != null) {
                account.setPassword(ConvertPasswordMD5.convertHashToString(account.getPassword()));
                if (a.getPassword().equals(account.getPassword())) {
                    return "OK";
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAILED";
    }

    @PostMapping("create")
    public String create(@RequestBody AccountDTO account) {
        System.out.println(account.getUsername() + " " + account.getPassword());
        AccountEntity a = accountService.findByUsername(account.getUsername());
        try {
            if (a == null) {
                account.setPassword(ConvertPasswordMD5.convertHashToString(account.getPassword()));
                a = new AccountDTO().convertToAccountEntity(account);
                accountService.save(a);
                return "OK";
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAILED";
    }

    @PutMapping("")
    public String updateAcount(@RequestBody AccountDTO account) {
        AccountEntity a = accountService.findByUsername(account.getUsername());
        try {
            account.setPassword(ConvertPasswordMD5.convertHashToString(account.getPassword()));
            a.setPassword(account.getPassword());
            accountService.save(a);
            return "OK";
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "FAILED";
    }
}
