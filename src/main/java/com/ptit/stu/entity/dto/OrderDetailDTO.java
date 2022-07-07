/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderDetailId;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
public class OrderDetailDTO {

    @Autowired
    ProductService productService;

    private Integer orderId;
    private Integer productId;
    private Integer quantity;
    private String productName;
    private Double price;

    public static OrderDetailDTO convertToOrderDetailDTO(OrderDetailEntity orderDetail) {
        OrderDetailDTO oD = new OrderDetailDTO();
        oD.setOrderId(orderDetail.getOrderDetailId().getOrderId());
        oD.setProductId(orderDetail.getOrderDetailId().getProductId());
        oD.setQuantity(orderDetail.getQuantity());
        ProductDTO pdto = ProductDTO.convertToProductDTO(orderDetail.getProduct());
        oD.setProductName(pdto.getName());
        oD.setPrice(pdto.getPrice() * orderDetail.getQuantity());
        return oD;
    }
}
