/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.OrderDAO;
import com.ptit.stu.entity.OrderEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDAO orderDAO;

    @Override
    public OrderEntity save(OrderEntity entity) {
        return orderDAO.save(entity);
    }

    @Override
    public List<OrderEntity> saveAll(List<OrderEntity> entities) {
        return (List<OrderEntity>) orderDAO.saveAll(entities);
    }

    @Override
    public Optional<OrderEntity> findById(Integer id) {
        return orderDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return orderDAO.existsById(id);
    }

    @Override
    public List<OrderEntity> findAll() {
        return (List<OrderEntity>) orderDAO.findAll();
    }

    @Override
    public List<OrderEntity> findAllById(List<Integer> ids) {
        return (List<OrderEntity>) orderDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return orderDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        orderDAO.deleteById(id);
    }

    @Override
    public void delete(OrderEntity entity) {
        orderDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        orderDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<OrderEntity> entities) {
        orderDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        orderDAO.deleteAll();
    }

    @Override
    public List<OrderEntity> getByAccountAndStatus(Integer account, Integer status) {
        return orderDAO.getByAccountAndStatus(account, status);
    }

    @Override
    public void updateStatus(Integer status, Integer order) {
        orderDAO.updateStatus(status, order);
    }

    @Override
    public List<OrderEntity> getAllByStatus(Integer status) {
        return orderDAO.getAllByStatus(status);
    }

}
