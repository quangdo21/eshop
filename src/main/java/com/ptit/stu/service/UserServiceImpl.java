/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.UserDAO;
import com.ptit.stu.entity.UserEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;

    @Override
    public UserEntity save(UserEntity entity) {
        return userDAO.save(entity);
    }

    @Override
    public List<UserEntity> saveAll(List<UserEntity> entities) {
        return (List<UserEntity>)userDAO.saveAll(entities);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return userDAO.existsById(id);
    }

    @Override
    public List<UserEntity> findAll() {
        return (List<UserEntity>)userDAO.findAll();
    }

    @Override
    public List<UserEntity> findAllById(List<Integer> ids) {
        return (List<UserEntity>)userDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return userDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    public void delete(UserEntity entity) {
        userDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        userDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<UserEntity> entities) {
        userDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        userDAO.deleteAll();
    }
    
    
}
