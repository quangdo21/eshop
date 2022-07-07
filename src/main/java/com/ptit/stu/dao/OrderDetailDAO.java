/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.dao;

import com.ptit.stu.entity.OrderDetailEntity;
import com.ptit.stu.entity.OrderDetailId;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dovan
 */
@Repository
public interface OrderDetailDAO extends CrudRepository<OrderDetailEntity, OrderDetailId>{
    
    @Query(value = "Select * from order_detail where order_detail.order_id = ?1", nativeQuery = true)
    List<OrderDetailEntity> findAllByOrderId(Integer id);
}
