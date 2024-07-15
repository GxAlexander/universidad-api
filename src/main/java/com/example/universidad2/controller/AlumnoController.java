package com.example.universidad2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.universidad2.model.Alumno;
import com.example.universidad2.service.AlumnoService;
import com.example.universidad2.model.Escuela;

import java.util.List;

@RestController
@RequestMapping("/universidad/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService){
    this.alumnoService=alumnoService;
    }

    @GetMapping
    public List<Alumno> getAllAlumnos(){
    return alumnoService.getAllAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getAlumnoById(@PathVariable Long id){
    Alumno alumno = alumnoService.getAlumnoById(id);
    return ResponseEntity.ok(alumno);
    }

    @PostMapping
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno){
    Alumno newAlumno = alumnoService.createAlumno(alumno);
    return ResponseEntity.ok(newAlumno);
    }

    @PutMapping("/{id}")
     public ResponseEntity<Alumno> updateAlumno(@PathVariable Long id,@RequestBody Alumno alumnoDetails ){
     Alumno updateAlumno =alumnoService.updateAlumno(id, alumnoDetails);
     return ResponseEntity.ok(updateAlumno);
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Alumno> deleteAlumno(@PathVariable Long id){
     alumnoService.deleteAlumno(id);
     return ResponseEntity.ok().build();
     }



}
