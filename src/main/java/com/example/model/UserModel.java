package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserModel {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;


    @Column(nullable = false)
    private String telefono;
    
    @Column(nullable = false)
    private String comuna;
}