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
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "[User]")
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(50)")
    private String name;
    private boolean gender;
    @Column(columnDefinition = "date")
    private Date birth;
    @Column(columnDefinition = "nvarchar(100)")
    private String address;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    private String email;
    
    @OneToMany(mappedBy = "user")
    private Collection<AccountEntity> accounts;
}
