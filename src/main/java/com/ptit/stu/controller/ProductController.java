/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.CatalogEntity;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.entity.dto.ProductDTO;
import com.ptit.stu.service.CatalogService;
import com.ptit.stu.service.ProductService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dovan
 */
//@Controller
//@RequestMapping("/products")
//public class ProductController {
//
//    @Autowired
//    ProductService productService;
//
//    @GetMapping("")
//    public String viewProduct(Model model) {
//        List<ProductEntity> listProduct = productService.findAll();
//        model.addAttribute("PRODUCTS", listProduct);
//        return "view_products";
//    }
//
//    @GetMapping("product-form")
//    public String productForm(Model model) {
//        ProductEntity product = new ProductEntity();
//        model.addAttribute("PRODUCT", product);
//        model.addAttribute("ACTION", "product-form");
//        return "product_form";
//    }
//
//    @PostMapping("product-form")
//    public String addProduct(@RequestParam("name") String name, @RequestParam("price") double price,
//            @RequestParam("quantity") int quantity, @RequestParam("descreption") String descreption,
//            @RequestParam("image") String image) {
//        ProductEntity product = new ProductEntity();
//        product.setName(name);
//        product.setPrice(price);
//        product.setQuantity(quantity);
//        product.setDescreptions(descreption);
//        product.setImage(image);
//        productService.save(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("product-form/edit/{id}")
//    public String editProduct(@PathVariable("id") int id, Model model) {
//        ProductEntity product = productService.findById(id).get();
//        model.addAttribute("PRODUCT", product);
//        model.addAttribute("ACTION", "/products/product-form/edit");
//        return "product_form";
//    }
//    
//    @PostMapping("product-form/edit")
//    public String updateProduct(@RequestParam("name") String name, @RequestParam("price") double price,
//            @RequestParam("quantity") int quantity, @RequestParam("descreption") String descreption,
//            @RequestParam("image") String image, @RequestParam("id") int id) {
//        ProductEntity product = productService.findById(id).get();
//        product.setName(name);
//        product.setPrice(price);
//        product.setDescreptions(descreption);
//        product.setQuantity(quantity);
//        product.setImage(image);
//        productService.save(product);
//        return "redirect:/products";
//    }
//    
//    @GetMapping("product-form/delete/{id}")
//    public String deleteProduct(@PathVariable("id") int id, Model model) {
//        productService.deleteById(id);
//        return "redirect:/products";
//    }
//}
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<ProductDTO> viewAllProduct() {
        List<ProductEntity> listProduct = productService.findAll();
        List<ProductDTO> Products = new ArrayList<>();
        for (ProductEntity p : listProduct) {
            Products.add(ProductDTO.convertToProductDTO(p));
        }
        return Products;
    }
    
    @GetMapping("{id}")
    public List<ProductDTO> viewProducts(@PathVariable Integer id) {
        List<ProductEntity> listProduct = productService.findAllByCatalog(id);
        List<ProductDTO> Products = new ArrayList<>();
        listProduct.sort((o1, o2) -> {
            return o2.getId() - o1.getId();
        });
        for (ProductEntity p : listProduct) {
            Products.add(ProductDTO.convertToProductDTO(p));
        }
        return Products;
    }

    @GetMapping("search")
    public List<ProductDTO> viewProductByName(@RequestParam(name = "value") String value) {
        List<ProductDTO> Products = new ArrayList<>();
        if (!value.isEmpty()) {
            List<ProductEntity> listProduct = productService.findAllByName("%" + value + "%");
            for (ProductEntity p : listProduct) {
                Products.add(ProductDTO.convertToProductDTO(p));
            }
        }
        return Products;
    }
    
    @GetMapping("catalog")
    public List<ProductDTO> viewProductByCatalog(@RequestParam(name = "id") Integer catalog) {
        List<ProductDTO> Products = new ArrayList<>();
        if (catalog != null) {
            List<ProductEntity> listProduct = productService.findAllByCatalog(catalog);
            for (ProductEntity p : listProduct) {
                Products.add(ProductDTO.convertToProductDTO(p));
            }
        }
        return Products;
    }
    
    @GetMapping("product")
    public ProductDTO viewProductById(@RequestParam(name = "id") Integer id){
        ProductEntity productEntity = productService.findById(id).get();
        ProductDTO product = ProductDTO.convertToProductDTO(productEntity);
        return product;
    }

    @PostMapping("")
    public ProductDTO addProduct(@RequestBody ProductDTO product) {
        product.setDescreptions(product.getDescreptions().replaceAll("\n", "<br>"));
        System.out.println(product.getDescreptions());
        ProductEntity p = new ProductDTO().convertToProductEntity(product);
        p.setCreated(new Date());
        productService.save(p);
        product = ProductDTO.convertToProductDTO(p);
        return product;
    }

    @DeleteMapping("")
    public String deleteProduct(@RequestParam(name = "id") int id) {
        productService.deleteById(id);
        return "Xoá thành công";
    }

    @PutMapping("")
    public ProductDTO updateProduct(@RequestBody ProductDTO product) {
        product.setDescreptions(product.getDescreptions().replaceAll("\n", "<br>"));
        System.out.println(product.getDescreptions());
        ProductEntity p = new ProductDTO().convertToProductEntity(product);
        productService.save(p);
        product = ProductDTO.convertToProductDTO(productService.findById(p.getId()).get());
        return product;
    }
    
    @GetMapping("top6pnew")
    public List<ProductDTO> getTop6Pnew(){
        List<ProductDTO> Products = new ArrayList<>();
        for (ProductEntity p : productService.getTop6Products()) {
            Products.add(ProductDTO.convertToProductDTO(p));
        }
        return Products;
    }
    
    @GetMapping("top6phone")
    public List<ProductDTO> getTop6Phone(){
        List<ProductDTO> Phones = new ArrayList<>();
        for (ProductEntity p : productService.getTop6Phones()) {
            Phones.add(ProductDTO.convertToProductDTO(p));
        }
        return Phones;
    }
    
    @GetMapping("top6tablet")
    public List<ProductDTO> getTop6Tablet(){
        List<ProductDTO> Tablets = new ArrayList<>();
        for (ProductEntity p : productService.getTop6Tablets()) {
            Tablets.add(ProductDTO.convertToProductDTO(p));
        }
        return Tablets;
    }
    
    @GetMapping("top6laptop")
    public List<ProductDTO> getTop6Laptop(){
        List<ProductDTO> Laptops = new ArrayList<>();
        for (ProductEntity p : productService.getTop6Laptops()) {
            Laptops.add(ProductDTO.convertToProductDTO(p));
        }
        return Laptops;
    }
    
    @GetMapping("top6accessories")
    public List<ProductDTO> getTop6Accessories(){
        List<ProductDTO> Accessories = new ArrayList<>();
        for (ProductEntity p : productService.getTop6Accessories()) {
            Accessories.add(ProductDTO.convertToProductDTO(p));
        }
        return Accessories;
    }
}
