/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.ProductDAO;
import com.ptit.stu.entity.ProductEntity;
import com.ptit.stu.entity.dto.ProductDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO productDAO;

    @Override
    public ProductEntity save(ProductEntity entity) {
        return productDAO.save(entity);
    }

    @Override
    public List<ProductEntity> saveAll(List<ProductEntity> entities) {
        return (List<ProductEntity>) productDAO.saveAll(entities);
    }

    @Override
    public Optional<ProductEntity> findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return productDAO.existsById(id);
    }

    @Override
    public List<ProductEntity> findAll() {
        return (List<ProductEntity>) productDAO.findAll();
    }

    @Override
    public List<ProductEntity> findAllById(List<Integer> ids) {
        return (List<ProductEntity>) productDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return productDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        productDAO.deleteById(id);
    }

    @Override
    public void delete(ProductEntity entity) {
        productDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        productDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<ProductEntity> entities) {
        productDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        productDAO.deleteAll();
    }

    @Override
    public List<ProductEntity> findAllByName(String name) {
        return productDAO.findAllByName(name);
    }

    @Override
    public List<ProductEntity> findAllByCatalog(Integer Catalog_id) {
        return productDAO.findAllByCatalog(Catalog_id);
    }

    @Override
    public List<ProductEntity> getTop6Products() {
        return productDAO.getTop6Products();
    }

    @Override
    public List<ProductEntity> getTop6Phones() {
        return productDAO.getTop6Phones();
    }

    @Override
    public List<ProductEntity> getTop6Tablets() {
        return productDAO.getTop6Tablets();
    }

    @Override
    public List<ProductEntity> getTop6Laptops() {
        return productDAO.getTop6Laptops();
    }

    @Override
    public List<ProductEntity> getTop6Accessories() {
        return productDAO.getTop6Accessories();
    }
}
