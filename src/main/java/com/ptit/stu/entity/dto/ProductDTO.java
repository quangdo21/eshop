/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.CatalogEntity;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.service.CatalogService;
import com.ptit.stu.service.CatalogServiceImpl;
import java.util.Date;
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
public class ProductDTO {

    @Autowired
    CatalogService catalogService;

    private Integer id;
    private String name;
    private Double price;
    private String image;
    private Date created = new Date();
    private String descreptions;
    private Integer catalog;

    public static ProductDTO convertToProductDTO(ProductEntity product) {
        ProductDTO p = new ProductDTO();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setImage(product.getImage());
        p.setDescreptions(product.getDescreptions());
        p.setCreated(product.getCreated());
        if (product.getCatalog() != null) {
            p.setCatalog(product.getCatalog().getId());
        }
        return p;
    }

    public ProductEntity convertToProductEntity(ProductDTO product) {
        ProductEntity p = new ProductEntity();
        if (product.getId() != null) {
            p.setId(product.getId());
        }
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setImage(product.getImage());
        if (product.getCreated() != null) {
            p.setCreated(product.getCreated());
        }
        p.setDescreptions(product.getDescreptions());
        CatalogEntity c = new CatalogEntity();
        c.setId(product.getCatalog());
        p.setCatalog(c);
        return p;
    }
}
