package com.example.universidad2.service;

import com.example.universidad2.model.Escuela;
import com.example.universidad2.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.universidad2.model.Alumno;
import com.example.universidad2.repository.AlumnoRepository;

import java.util.List;

@Service
public class AlumnoService {
    private final AlumnoRepository alumnoRepository;
    private final EscuelaRepository escuelaRepository;

    //Contructor
    @Autowired
    public AlumnoService (AlumnoRepository alumnoRepository, EscuelaRepository escuelaRepository){
    this.alumnoRepository=alumnoRepository;
        this.escuelaRepository = escuelaRepository;
    }

    //Obtener todos los alumnos
    public List<Alumno> getAllAlumnos(){return alumnoRepository.findAll();}

    //Obtener un alumno por su id
    public Alumno getAlumnoById(Long alumno ){
    return alumnoRepository.findById(alumno)
            .orElseThrow(()-> new RuntimeException ("Alumno No encontrado"));
    }

    //Crear un alumno
    public Alumno createAlumno(Alumno alumno){

        //saber si existe o no la escuela para asignarla
    if (alumno.getEscuela()!=null && alumno.getEscuela().getId()!=null){
        Escuela escuela = escuelaRepository.findById(alumno.getEscuela().getId())
                .orElseThrow(()-> new RuntimeException ("Escuela No encontrada"));
        alumno.setEscuela(escuela);
    }else {
        alumno.setEscuela(null);
    }

        return alumnoRepository.save(alumno);
    }

    //Actualizar un alumno
    public Alumno updateAlumno(Long alumnoId, Alumno alumnoDetails){
    Alumno alumno = alumnoRepository.findById(alumnoId)
            .orElseThrow(()-> new RuntimeException ("Alumno No encontrado"));
           alumno.setNombre(alumnoDetails.getNombre());
           alumno.setCodigo(alumnoDetails.getCodigo());
           alumno.setApellido(alumnoDetails.getApellido());

           //saber si existe o no la escuela para asignarla
           if(alumnoDetails.getEscuela()!=null && alumnoDetails.getEscuela().getId()!=null){
            Escuela escuela = escuelaRepository.findById(alumnoDetails.getEscuela().getId())
                    .orElseThrow(()-> new RuntimeException ("Escuela No encontrada"));
            alumno.setEscuela(escuela);
        }else {
            alumno.setEscuela(null);
        }

           return alumnoRepository.save(alumno);
    }

    //eliminar un alumno
    public void deleteAlumno(Long alumnoId){
    Alumno alumno = alumnoRepository.findById(alumnoId)
            .orElseThrow(()-> new RuntimeException ("Alumno No encontrado"));
    alumnoRepository.delete(alumno);
    }


}
