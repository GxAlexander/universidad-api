/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.universidad2.controller;

import com.example.universidad2.model.Escuela;
import com.example.universidad2.service.EscuelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universidad/escuelas")
public class EscuelaController {
    private final EscuelaService escuelaSerice;
    
    @Autowired
    public EscuelaController(EscuelaService escuelaSerice){
    this.escuelaSerice=escuelaSerice;
    }
    
    @GetMapping
    public List<Escuela> getAllEscuelas(){
    return escuelaSerice.getAllEscuelas();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuelaById(@PathVariable Long id){
    Escuela escuela = escuelaSerice.getEscuelaById(id);
    return ResponseEntity.ok(escuela);
    }

    
    @PostMapping
    public ResponseEntity<Escuela> createEscuela(@RequestBody Escuela escuela){
    Escuela newEscuela = escuelaSerice.createEscuela(escuela);
    return ResponseEntity.ok(newEscuela);
    }
    
    @PutMapping("/{id}")
     public ResponseEntity<Escuela> updateEscuela(@PathVariable Long id,@RequestBody Escuela escuelaDetails ){
     Escuela updateEscuela =escuelaSerice.updateEscuela(id, escuelaDetails);
     return ResponseEntity.ok(updateEscuela);
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Escuela> deleteEscuela(@PathVariable Long id){
     escuelaSerice.deleteEscuela(id);
     return ResponseEntity.ok().build();
     }
            
    
}
