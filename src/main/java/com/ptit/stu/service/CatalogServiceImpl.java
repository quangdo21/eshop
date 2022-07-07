/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.CatalogDAO;
import com.ptit.stu.entity.CatalogEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    CatalogDAO catalogDAO;

    @Override
    public CatalogEntity save(CatalogEntity entity) {
        return catalogDAO.save(entity);
    }

    @Override
    public List<CatalogEntity> saveAll(List<CatalogEntity> entities) {
        return (List<CatalogEntity>) catalogDAO.saveAll(entities);
    }

    @Override
    public Optional<CatalogEntity> findById(Integer id) {
        return catalogDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return catalogDAO.existsById(id);
    }

    @Override
    public List<CatalogEntity> findAll() {
        return (List<CatalogEntity>) catalogDAO.findAll();
    }

    @Override
    public List<CatalogEntity> findAllById(List<Integer> ids) {
        return (List<CatalogEntity>) catalogDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return catalogDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        catalogDAO.deleteById(id);
    }

    @Override
    public void delete(CatalogEntity entity) {
        catalogDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        catalogDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<CatalogEntity> entities) {
        catalogDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        catalogDAO.deleteAll();
    }
}
