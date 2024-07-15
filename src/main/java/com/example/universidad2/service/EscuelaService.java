/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universidad2.service;
import com.example.universidad2.model.Escuela;
import com.example.universidad2.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author C27444
 */
@Service
public class EscuelaService {
    private final EscuelaRepository escuelaRepository;
    
    @Autowired
    public EscuelaService (EscuelaRepository escuelaRepository){
    this.escuelaRepository=escuelaRepository;
    }
    
    public List<Escuela> getAllEscuelas(){return escuelaRepository.findAll();}
    
    public Escuela getEscuelaById(Long escuelaId){
    return escuelaRepository.findById(escuelaId)
            .orElseThrow(()-> new RuntimeException ("Escuela No encontrada"));    
    
    }
    
    public Escuela createEscuela(Escuela escuela){
    return escuelaRepository.save(escuela);
    }
    
    public Escuela updateEscuela(Long escuelaId, Escuela escuelaDetails){
    Escuela escuela = escuelaRepository.findById(escuelaId)
            .orElseThrow(()-> new RuntimeException ("Escuela No encontrada"));
           escuela.setNombre(escuelaDetails.getNombre());
           return escuelaRepository.save(escuela);
    
    }
    
    public void deleteEscuela(Long escuelaId){
    Escuela escuela = escuelaRepository.findById(escuelaId)
            .orElseThrow(()-> new RuntimeException ("Escuela No encontrada"));
    escuelaRepository.delete(escuela);
    }
    
    
    
    
}
