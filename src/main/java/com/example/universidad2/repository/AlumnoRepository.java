package com.example.universidad2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.universidad2.model.Alumno;


public interface AlumnoRepository extends JpaRepository<Alumno,Long> {
    Alumno findByNombre(String nombre);
}
