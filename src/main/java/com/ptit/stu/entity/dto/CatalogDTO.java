/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.CatalogEntity;
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
public class CatalogDTO {
    private Integer id;
    private String name;
    
    public static CatalogEntity convertToCatalogEntity(CatalogDTO catalog){
        CatalogEntity c = new CatalogEntity();
        c.setId(catalog.getId());
        c.setName(catalog.getName());
        return c;
    }
    
    public static CatalogDTO convertToCatalogDTO(CatalogEntity catalog){
        CatalogDTO c = new CatalogDTO();
        c.setId(catalog.getId());
        c.setName(catalog.getName());
        return c;
    }
}
