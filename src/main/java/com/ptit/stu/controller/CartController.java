/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.ProductCart;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.service.ProductService;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dovan
 */
@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    ProductService productService;
    
    @GetMapping("")
    public String viewCart(HttpSession session){
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>)session.getAttribute("CART");
        if(cart == null){
            session.setAttribute("PRICE", 0.0);
        }
        return "cart";
    }
    
    @GetMapping("{id}")
    public String addToCart(@PathVariable Integer id, HttpSession session){
        ProductEntity p = productService.findById(id).get();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>)session.getAttribute("CART");
        if(cart == null){
            cart = new HashMap<>();
            ProductCart productCart = new ProductCart(p, 1, p.getPrice());
            cart.put(id, productCart);
        } else {
            session.removeAttribute("PRICE");
            session.removeAttribute("CART");
            if(cart.containsKey(id)){
                ProductCart productCart = cart.get(id);
                productCart.incrementQuantity();
            } else {
                ProductCart productCart = new ProductCart(p, 1, p.getPrice());
                cart.put(id, productCart);
            }
        }
        double price = 0;
        for(ProductCart pC:cart.values()){
            price += pC.getQuantity()*pC.getProduct().getPrice();
            System.out.println(pC.getProduct().getPrice() + " " + pC.getQuantity());
        }
        session.setAttribute("PRICE", price);
        session.setAttribute("CART", cart);
        return "cart";
    }
    
    @GetMapping("/delete/{id}")
    public String removeFromCart(@PathVariable Integer id, HttpSession session){
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>)session.getAttribute("CART");
        cart.remove(id);
        session.removeAttribute("PRICE");
        session.removeAttribute("CART");
        double price = 0;
        for(ProductCart pC:cart.values()){
            price += pC.getQuantity()*pC.getProduct().getPrice();
            System.out.println(pC.getProduct().getPrice() + " " + pC.getQuantity());
        }
        session.setAttribute("PRICE", price);
        session.setAttribute("CART", cart);
        return "cart";
    }
    
    @GetMapping("/reduction/{id}")
    public String reductionFromCart(@PathVariable Integer id, HttpSession session){
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>)session.getAttribute("CART");
        if(cart.get(id).getQuantity() == 1){
            cart.remove(id);
        } else {
            ProductCart productCart = cart.get(id);
            productCart.reductionQuantity();
        }
        session.removeAttribute("PRICE");
        session.removeAttribute("CART");
        double price = 0;
        for(ProductCart pC:cart.values()){
            price += pC.getQuantity()*pC.getProduct().getPrice();
            System.out.println(pC.getProduct().getPrice() + " " + pC.getQuantity());
        }
        session.setAttribute("PRICE", price);
        session.setAttribute("CART", cart);
        return "cart";
    }
}
