/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.AccountEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface AccountService {

    long count();

    void delete(AccountEntity entity);

    void deleteAll();

    void deleteAll(List<AccountEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<AccountEntity> findAll();

    List<AccountEntity> findAllById(List<Integer> ids);

    Optional<AccountEntity> findById(Integer id);

    AccountEntity save(AccountEntity entity);

    List<AccountEntity> saveAll(List<AccountEntity> entities);

    AccountEntity findByUsername(String username);
    
}
