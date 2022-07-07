/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderDetailId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface OrderDetailService {

    long count();

    void delete(OrderDetailEntity entity);

    void deleteAll();

    void deleteAll(List<OrderDetailEntity> entities);

    void deleteAllById(List<OrderDetailId> ids);

    void deleteById(OrderDetailId id);

    boolean existsById(OrderDetailId id);

    List<OrderDetailEntity> findAll();

    List<OrderDetailEntity> findAllById(List<OrderDetailId> ids);

    Optional<OrderDetailEntity> findById(OrderDetailId id);

    OrderDetailEntity save(OrderDetailEntity entity);

    List<OrderDetailEntity> saveAll(List<OrderDetailEntity> entities);

    List<OrderDetailEntity> findAllByOrderId(Integer id);
    
}
