/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ptit.stu.dao;

import com.ptit.stu.entity.OrderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dovan
 */
@Repository
public interface OrderDAO extends CrudRepository<OrderEntity, Integer>{
    
    @Query(value = "select * from [order] where [order].account_id = ?1 and [order].[status] = ?2 order by [order].id desc", nativeQuery = true)
    public List<OrderEntity> getByAccountAndStatus(Integer account, Integer status);
    
    @Query(value = "update [order] set [order].[status] = ?1 where [order].id = ?2", nativeQuery = true)
    public void updateStatus(Integer status, Integer order);
    
    @Query(value = "select * from [order] where [order].[status] = ?1 order by [order].id desc", nativeQuery = true)
    public List<OrderEntity> getAllByStatus(Integer status);
}
