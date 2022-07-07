/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.AccountDAO;
import com.ptit.stu.entity.AccountEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDAO accountDAO;

    @Override
    public AccountEntity save(AccountEntity entity) {
        return accountDAO.save(entity);
    }

    @Override
    public List<AccountEntity> saveAll(List<AccountEntity> entities) {
        return (List<AccountEntity>) accountDAO.saveAll(entities);
    }

    @Override
    public Optional<AccountEntity> findById(Integer id) {
        return accountDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return accountDAO.existsById(id);
    }

    @Override
    public List<AccountEntity> findAll() {
        return (List<AccountEntity>) accountDAO.findAll();
    }

    @Override
    public List<AccountEntity> findAllById(List<Integer> ids) {
        return (List<AccountEntity>) accountDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return accountDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        accountDAO.deleteById(id);
    }

    @Override
    public void delete(AccountEntity entity) {
        accountDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        accountDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<AccountEntity> entities) {
        accountDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        accountDAO.deleteAll();
    }

    @Override
    public AccountEntity findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

}
