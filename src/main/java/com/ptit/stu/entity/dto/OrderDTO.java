/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderEntity;
import com.ptit.stu.service.OrderDetailService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class OrderDTO {
    @Autowired
    OrderDetailService orderDetailService;
    
    private Integer id;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String message;
    private Date created;
    private Integer status;
    private Integer account;
    private Double price;
    private String transport;
    private List<OrderDetailDTO> orderDetails;
    
    public static OrderDTO convertToOrderDTO(OrderEntity order){
        OrderDTO od = new OrderDTO();
        List<OrderDetailDTO> list = new ArrayList<>();
        List<OrderDetailEntity> le = (List<OrderDetailEntity>)order.getOrderDetails();
        for(OrderDetailEntity o: le){
            list.add(OrderDetailDTO.convertToOrderDetailDTO(o));
        }
        Double price = 0.0;
        for(OrderDetailDTO o: list){
            price += o.getPrice();
        }
        od.setTransport(order.getTransport());
        od.setStatus(order.getStatus());
        od.setPrice(price);
        od.setId(order.getId());
        od.setCustomerName(order.getCustomerName());
        od.setCustomerAddress(order.getCustomerAddress());
        od.setCustomerPhone(order.getCustomerPhone());
        od.setMessage(order.getMessage());
        od.setCreated(order.getCreated());
        od.setAccount(order.getAccount().getId());
        od.setOrderDetails(list);
        return od;
    }
}
