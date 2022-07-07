/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.controller;

import com.ptit.stu.entity.CatalogEntity;
import com.ptit.stu.entity.dto.CatalogDTO;
import com.ptit.stu.service.CatalogService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dovan
 */
@RestController
@RequestMapping("catalog")
public class CatalogController {
    @Autowired
    CatalogService catalogService;
    
    @GetMapping("")
    public List<CatalogDTO> getCatalog(){
        List<CatalogDTO> Catalogs = new ArrayList<>();
        for (CatalogEntity c : catalogService.findAll()) {
            Catalogs.add(CatalogDTO.convertToCatalogDTO(c));
        }
        return Catalogs;
    }
}
