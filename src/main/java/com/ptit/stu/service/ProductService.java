/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.entity.dto.ProductDTO;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface ProductService {

    long count();

    void delete(ProductEntity entity);

    void deleteAll();

    void deleteAll(List<ProductEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<ProductEntity> findAll();

    List<ProductEntity> findAllById(List<Integer> ids);

    Optional<ProductEntity> findById(Integer id);

    ProductEntity save(ProductEntity entity);

    List<ProductEntity> saveAll(List<ProductEntity> entities);

    List<ProductEntity> findAllByName(String name);

    List<ProductEntity> findAllByCatalog(Integer Catalog_id);

    List<ProductEntity> getTop6Products();

    List<ProductEntity> getTop6Accessories();

    List<ProductEntity> getTop6Laptops();

    List<ProductEntity> getTop6Phones();

    List<ProductEntity> getTop6Tablets();
}
