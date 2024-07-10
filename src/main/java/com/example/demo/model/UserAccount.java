package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import jakarta.persistence.ManyToOne;
import lombok.Getter; 
import lombok.Setter; 

@Getter 
@Setter 
@Entity 
public class UserAccount { 
    @Id     // PK 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INC
    private Integer accountID;

    @Column(nullable = false, unique = true)
    private String accountNum;

    @Column(nullable = false)
    private String accountPW;

    @ManyToOne 
    private User user; 
    
    @Column
    private Integer balance;
}