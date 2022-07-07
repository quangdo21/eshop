/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.CatalogEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface CatalogService {

    long count();

    void delete(CatalogEntity entity);

    void deleteAll();

    void deleteAll(List<CatalogEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<CatalogEntity> findAll();

    List<CatalogEntity> findAllById(List<Integer> ids);
    
    Optional<CatalogEntity> findById(Integer id);

    CatalogEntity save(CatalogEntity entity);

    List<CatalogEntity> saveAll(List<CatalogEntity> entities);
    
}
