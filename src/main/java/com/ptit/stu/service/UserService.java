/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.UserEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface UserService {

    long count();

    void delete(UserEntity entity);

    void deleteAll();

    void deleteAll(List<UserEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<UserEntity> findAll();

    List<UserEntity> findAllById(List<Integer> ids);

    Optional<UserEntity> findById(Integer id);

    UserEntity save(UserEntity entity);

    List<UserEntity> saveAll(List<UserEntity> entities);
    
}
