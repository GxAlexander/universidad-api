/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universidad2.model;
import jakarta.persistence.*;
import lombok.Data;
/**
 *
 * @author C27444
 */
@Data
@Entity
@Table(name="escuela")
public class Escuela {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition="INT")
    private Long id;
    
    @Column(name="nombre", nullable=false)
    private String nombre;
    
    
    
}
