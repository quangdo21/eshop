/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ptit.stu.entity.dto;

import com.ptit.stu.entity.EvaluationEntity;
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
public class EvaluationDTO {
    private Integer id;
    private Integer point;
    private String message;
    private String username;
    
    public static EvaluationDTO convetToEvaluationDTO(EvaluationEntity entity){
        EvaluationDTO e = new EvaluationDTO();
        e.setId(entity.getId());
        e.setPoint(entity.getPoint());
        e.setMessage(entity.getMessage());
        e.setUsername(entity.getAccount().getUsername());
        return e;
    }
}
