/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity;

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
public class ProductCart {
    private ProductEntity product;
    private int quantity;
    private double price;
    
    public void incrementQuantity(){
        this.quantity++;
        this.price += this.product.getPrice();
    }
    
    public void reductionQuantity(){
        this.quantity--;
        this.price -= this.product.getPrice();
    }
}
