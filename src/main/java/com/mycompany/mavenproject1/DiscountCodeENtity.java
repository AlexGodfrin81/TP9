/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author pedago
 */
public class DiscountCodeENtity {
    
    String code;
    float taux;
    
    public DiscountCodeENtity(String n, float m){
        this.code = n;
        this.taux = m;
        
    }
    
    public String getCode(){
        return code;
    }
    
    public float getTaux(){
        return taux;
    }
    
}
