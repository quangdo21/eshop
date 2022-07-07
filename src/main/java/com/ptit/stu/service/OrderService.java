/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.OrderDAO;
import com.ptit.stu.entity.OrderEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dovan
 */
public interface OrderService {

    long count();

    void delete(OrderEntity entity);

    void deleteAll();

    void deleteAll(List<OrderEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<OrderEntity> findAll();

    List<OrderEntity> findAllById(List<Integer> ids);

    Optional<OrderEntity> findById(Integer id);

    OrderEntity save(OrderEntity entity);

    List<OrderEntity> saveAll(List<OrderEntity> entities);

    List<OrderEntity> getByAccountAndStatus(Integer account, Integer status);

    void updateStatus(Integer status, Integer order);

    List<OrderEntity> getAllByStatus(Integer status);

}
