/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.AccountEntity;
import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderDetailId;
import com.ptit.stu.entity.OrderEntity;
import com.ptit.stu.entity.ProductCart;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.entity.UserEntity;
import com.ptit.stu.entity.dto.ProductDTO;
import com.ptit.stu.service.AccountService;
import com.ptit.stu.service.OrderDetailService;
import com.ptit.stu.service.OrderService;
import com.ptit.stu.service.ProductService;
import com.ptit.stu.service.UserService;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dovan
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    AccountService accountService;
    @Autowired
    ProductService productService;

    @GetMapping("")
    public String viewPayment(HttpSession session, Model model) {
        Integer id = (Integer) session.getAttribute("USERID");
        UserEntity userEntity = userService.findById(id).get();
        model.addAttribute("NAME", userEntity.getName());
        model.addAttribute("PHONE", userEntity.getPhone());
        model.addAttribute("ADDRESS", userEntity.getAddress());
        model.addAttribute("TYPE", 0);
        return "payment";
    }

    @GetMapping("{id}")
    public String view1Payment(HttpSession session, Model model, @PathVariable Integer id) {
        ProductEntity p = productService.findById(id).get();
        Integer ide = (Integer) session.getAttribute("USERID");
        UserEntity userEntity = userService.findById(ide).get();
        model.addAttribute("NAME", userEntity.getName());
        model.addAttribute("PHONE", userEntity.getPhone());
        model.addAttribute("ADDRESS", userEntity.getAddress());
        model.addAttribute("TYPE", 1);
        ProductDTO pdto = ProductDTO.convertToProductDTO(p);
        model.addAttribute("PRODUCTS", pdto);
        return "payment";
    }

    @PostMapping("")
    public String payOrder(@RequestParam("name") String name,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("message") String message,
            @RequestParam("type") Integer type,
            @RequestParam("idP") Integer idP,
            HttpSession session) {
        AccountEntity ac = accountService.findByUsername((String) session.getAttribute("USERNAME"));
        OrderEntity order = new OrderEntity();
        order.setCustomerName(name);
        order.setCustomerAddress(address);
        order.setCustomerPhone(phone);
        order.setMessage(message);
        order.setStatus(1);
        order.setAccount(ac);
        orderService.save(order);
        if (type == 0) {
            HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("CART");
            for (ProductCart pC : cart.values()) {
                OrderDetailId odid = new OrderDetailId(order.getId(), pC.getProduct().getId());
                OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
                orderDetailEntity.setQuantity(pC.getQuantity());
                orderDetailEntity.setOrderDetailId(odid);
                orderDetailEntity.setOrder(order);
                orderDetailEntity.setProduct(pC.getProduct());
                orderDetailService.save(orderDetailEntity);
            }
        } else {
            ProductEntity p = productService.findById(idP).get();
            OrderDetailId odid = new OrderDetailId(order.getId(), p.getId());
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setQuantity(1);
            orderDetailEntity.setOrderDetailId(odid);
            orderDetailEntity.setOrder(order);
            orderDetailEntity.setProduct(p);
            orderDetailService.save(orderDetailEntity);
        }

        session.removeAttribute("CART");
        return "info_order";
    }
}
