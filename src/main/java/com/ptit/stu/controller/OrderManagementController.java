/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dovan
 */
@Controller
@RequestMapping("/order-management")
public class OrderManagementController {
    @GetMapping("")
    public String viewOrderManager(){
        return "order_management";
    }
}
