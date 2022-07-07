/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.dao;

import com.ptit.stu.entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dovan
 */
@Repository
public interface ProductDAO extends CrudRepository<ProductEntity, Integer>{
    
    @Query(value = "select * from product where product.status = 1", nativeQuery = true)
    List<ProductEntity> findAll();
    
    @Query("select product from ProductEntity product where product.name like ?1 and product.status = 1")
    List<ProductEntity> findAllByName(String name);
    
    @Query(value = "select * from product where product.catalog_id = ?1 and product.status = 1", nativeQuery = true)
    List<ProductEntity> findAllByCatalog(Integer Catalog_id);
    
    @Query(value = "select top(6) * from product where product.status = 1 order by id desc", nativeQuery = true)
    List<ProductEntity> getTop6Products();
    
    @Query(value = "select top(6) * from product  where product.catalog_id = 1 and product.status = 1 order by id desc", nativeQuery = true)
    List<ProductEntity> getTop6Phones();
    
    @Query(value = "select top(6) * from product  where product.catalog_id = 2 and product.status = 1 order by id desc", nativeQuery = true)
    List<ProductEntity> getTop6Tablets();
    
    @Query(value = "select top(6) * from product  where product.catalog_id = 3 and product.status = 1 order by id desc", nativeQuery = true)
    List<ProductEntity> getTop6Laptops();
    
    @Query(value = "select top(6) * from product  where product.catalog_id = 4 and product.status = 1 order by id desc", nativeQuery = true)
    List<ProductEntity> getTop6Accessories();
    
}
