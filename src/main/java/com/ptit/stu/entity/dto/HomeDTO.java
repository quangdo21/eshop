/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import java.util.List;
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
public class HomeDTO {
    private List<CatalogDTO> catalog;
    private List<ProductDTO> newProducts;
    private List<ProductDTO> phones;
    private List<ProductDTO> tablets;
    private List<ProductDTO> laptops;
    private List<ProductDTO> accessories;
}
