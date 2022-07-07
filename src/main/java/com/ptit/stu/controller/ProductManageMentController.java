/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.entity.dto.ProductDTO;
import com.ptit.stu.service.ProductService;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/product-management")
public class ProductManageMentController {
    @Autowired
    ProductService productService;
    
    @GetMapping("")
    public String viewProductM(Model model){
        List<ProductEntity> list = productService.findAll();
        List<ProductDTO> listP = new ArrayList<>();
        for(ProductEntity pe: list){
            listP.add(ProductDTO.convertToProductDTO(pe));
        }
        model.addAttribute("LISTP", listP);
        return "product_management";
    }
    
    @GetMapping("/{message}")
    public String searchProduct(Model model, @PathVariable String message){
        System.out.println(message);
        List<ProductEntity> list = productService.findAllByName("%" + message + "%");
        List<ProductDTO> listP = new ArrayList<>();
        for(ProductEntity pe: list){
            listP.add(ProductDTO.convertToProductDTO(pe));
        }
        model.addAttribute("LISTP", listP);
        return "product_management";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id, Model model){
        ProductEntity p = productService.findById(id).get();
        p.setStatus(0);
        productService.save(p);
        return "redirect:/product-management";
    }
    
    @GetMapping("/update/{id}")
    public String viewUpdateProduct(@PathVariable Integer id, Model model){
        ProductEntity p = productService.findById(id).get();
        model.addAttribute("PRODUCT", p);
        model.addAttribute("ACTION", "/product-management/update");
        return "add_product";
    }
    @PostMapping("/update")
    public String updateProduct(@RequestParam("id") Integer id,
            @RequestParam("name") String name,
           @RequestParam("type") Integer type,
           @RequestParam("price") Double price,
           @RequestParam("descriptions") String descriptions,
           @RequestParam("image") String image){
        ProductDTO p = ProductDTO.convertToProductDTO(productService.findById(id).get());
        descriptions = descriptions.replaceAll("\n", "<br>");
        p.setId(id);
        p.setCatalog(type);
        p.setName(name);
        p.setPrice(price);
        p.setDescreptions(descriptions);
        p.setImage(image);
        ProductEntity pe = new ProductDTO().convertToProductEntity(p);
        productService.save(pe);
        return "redirect:/product-management";
    }
    
    
    @GetMapping("/add")
    public String viewAddP(Model model){
        ProductEntity p = new ProductEntity();
        model.addAttribute("PRODUCT", p);
        model.addAttribute("ACTION", "add");
        return "add_product";
    }
    
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
           @RequestParam("type") Integer type,
           @RequestParam("price") Double price,
           @RequestParam("descriptions") String descriptions,
           @RequestParam("image") String image){
        descriptions = descriptions.replaceAll("\n", "<br>");
        ProductDTO p = new ProductDTO();
        p.setCatalog(type);
        p.setName(name);
        p.setPrice(price);
        p.setDescreptions(descriptions);
        p.setImage(image);
        ProductEntity pe = new ProductDTO().convertToProductEntity(p);
        productService.save(pe);
        return "redirect:/product-management";
    }
}
