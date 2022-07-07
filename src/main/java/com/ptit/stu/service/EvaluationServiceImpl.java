/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.dao.EvaluationDAO;
import com.ptit.stu.entity.EvaluationEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dovan
 */
@Service
public class EvaluationServiceImpl implements EvaluationService{
    @Autowired
    EvaluationDAO evaluationDAO;

    @Override
    public EvaluationEntity save(EvaluationEntity entity) {
        return evaluationDAO.save(entity);
    }

    @Override
    public List<EvaluationEntity> saveAll(List<EvaluationEntity> entities) {
        return (List<EvaluationEntity>)evaluationDAO.saveAll(entities);
    }

    @Override
    public Optional<EvaluationEntity> findById(Integer id) {
        return evaluationDAO.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return evaluationDAO.existsById(id);
    }

    @Override
    public List<EvaluationEntity> findAll() {
        return (List<EvaluationEntity>)evaluationDAO.findAll();
    }

    @Override
    public List<EvaluationEntity> findAllById(List<Integer> ids) {
        return (List<EvaluationEntity>)evaluationDAO.findAllById(ids);
    }

    @Override
    public long count() {
        return evaluationDAO.count();
    }

    @Override
    public void deleteById(Integer id) {
        evaluationDAO.deleteById(id);
    }

    @Override
    public void delete(EvaluationEntity entity) {
        evaluationDAO.delete(entity);
    }

    @Override
    public void deleteAllById(List<Integer> ids) {
        evaluationDAO.deleteAllById(ids);
    }

    @Override
    public void deleteAll(List<EvaluationEntity> entities) {
        evaluationDAO.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        evaluationDAO.deleteAll();
    }

    @Override
    public List<EvaluationEntity> getEvaluationByProduct(Integer product) {
        return evaluationDAO.getEvaluationByProduct(product);
    }
    
    
}
