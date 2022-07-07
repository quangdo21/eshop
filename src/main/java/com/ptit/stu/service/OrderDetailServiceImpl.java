/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.OrderDetailDAO;
import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderDetailId;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Override
    public OrderDetailEntity save(OrderDetailEntity entity) {
        return orderDetailDAO.save(entity);
    }

    @Override
    public List<OrderDetailEntity> saveAll(List<OrderDetailEntity> entities) {
        return (List<OrderDetailEntity>)orderDetailDAO.saveAll(entities);
    }

    @Override
    public Optional<OrderDetailEntity> findById(OrderDetailId id) {
        return orderDetailDAO.findById(id);
    }

    @Override
    public boolean existsById(OrderDetailId id) {
        return orderDetailDAO.existsById(id);
    }

    @Override
    public List<OrderDetailEntity> findAll() {
        return (List<OrderDetailEntity>)orderDetailDAO.findAll();
    }

    @Override
    public List<OrderDetailEntity> findAllById(List<OrderDetailId> ids) {
        return (List<OrderDetailEntity>)orderDetailDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return orderDetailDAO.count();
    }

    @Override
    public void deleteById(OrderDetailId id) {
        orderDetailDAO.deleteById(id);
    }

    @Override
    public void delete(OrderDetailEntity entity) {
        orderDetailDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<OrderDetailId> ids) {
        orderDetailDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<OrderDetailEntity> entities) {
        orderDetailDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        orderDetailDAO.deleteAll();
    }

    @Override
    public List<OrderDetailEntity> findAllByOrderId(Integer id) {
        return orderDetailDAO.findAllByOrderId(id);
    }
    
}
