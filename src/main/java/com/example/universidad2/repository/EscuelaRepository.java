/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universidad2.repository;

import com.example.universidad2.model.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author C27444
 */
public interface EscuelaRepository extends JpaRepository<Escuela,Long> {
    Escuela findByNombre(String nombre);
}
