/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.service;

import com.ptit.stu.entity.EvaluationEntity;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dovan
 */
public interface EvaluationService {

    long count();

    void delete(EvaluationEntity entity);

    void deleteAll();

    void deleteAll(List<EvaluationEntity> entities);

    void deleteAllById(List<Integer> ids);

    void deleteById(Integer id);

    boolean existsById(Integer id);

    List<EvaluationEntity> findAll();

    List<EvaluationEntity> findAllById(List<Integer> ids);

    Optional<EvaluationEntity> findById(Integer id);

    EvaluationEntity save(EvaluationEntity entity);

    List<EvaluationEntity> saveAll(List<EvaluationEntity> entities);

    List<EvaluationEntity> getEvaluationByProduct(Integer product);
    
}
