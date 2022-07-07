/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.dao;

import com.ptit.stu.entity.EvaluationEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dovan
 */
@Repository
public interface EvaluationDAO extends CrudRepository<EvaluationEntity, Integer>{
    @Query(value = "SELECT * FROM [evaluation] WHERE [evaluation].product_id = ?1", nativeQuery = true)
    List<EvaluationEntity> getEvaluationByProduct(Integer product);
}
