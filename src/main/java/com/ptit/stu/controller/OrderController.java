/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderEntity;
import com.ptit.stu.entity.dto.OrderDTO;
import com.ptit.stu.entity.dto.OrderDetailDTO;
import com.ptit.stu.service.OrderDetailService;
import com.ptit.stu.service.OrderService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dovan
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    
    @GetMapping("")
    public List<OrderDTO> getAllOder(){
        List<OrderEntity> l = orderService.findAll();
        List<OrderDTO> ldto = new ArrayList<>();
        for(OrderEntity o: l){
            ldto.add(OrderDTO.convertToOrderDTO(o));
        }
        return ldto;
    }
    
    @GetMapping("{id}/{status}")
    public List<OrderDTO> getOrderByAccount(@PathVariable Integer id, @PathVariable Integer status){
        List<OrderEntity> l = orderService.getByAccountAndStatus(id, status);
        List<OrderDTO> ldto = new ArrayList<>();
        for(OrderEntity o: l){
            ldto.add(OrderDTO.convertToOrderDTO(o));
        }
        return ldto;
    }
    
    @GetMapping("/cancel/{order}")
    public void cancelOrder(@PathVariable Integer order){
        orderService.updateStatus(0, order);
    }
    
    @GetMapping("/receive/{order}")
    public void receiveOrder(@PathVariable Integer order){
        orderService.updateStatus(3, order);
    }
    
    @GetMapping("/update/{order}/{transpost}/{number}")
    public void updateOrder(@PathVariable Integer order, @PathVariable String transpost, @PathVariable String number){
        transpost = "Đơn vị: "+transpost + "<br/>Vận đơn: " + number;
        OrderEntity oe = orderService.findById(order).get();
        oe.setStatus(2);
        oe.setTransport(transpost);
        orderService.save(oe);
    }
    
    @GetMapping("/{status}")
    public List<OrderDTO> getALLByStatus(@PathVariable Integer status){
        List<OrderEntity> l = orderService.getAllByStatus(status);
        List<OrderDTO> ldto = new ArrayList<>();
        for(OrderEntity o: l){
            ldto.add(OrderDTO.convertToOrderDTO(o));
        }
        return ldto;
    }
}
