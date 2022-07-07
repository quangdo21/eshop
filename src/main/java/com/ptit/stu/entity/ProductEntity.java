/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dovan
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Product")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(100)")
    private String name;
    private Double price;
    private String image;
    private Date created = new Date();
    @Column(columnDefinition = "nvarchar(max)")
    private String descreptions;
    private Integer status = 1;

    @ManyToOne
    @JoinColumn(name = "catalogId")
    private CatalogEntity catalog;

   @OneToMany(mappedBy = "product")
    private Collection<OrderDetailEntity> orderDetails;

    @OneToMany(mappedBy = "product")
    private Collection<EvaluationEntity> evaluations;
}
