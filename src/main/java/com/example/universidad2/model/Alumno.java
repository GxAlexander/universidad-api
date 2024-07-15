
package com.example.universidad2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author C27444
 */
@Data
@Entity
@Table(name="alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition="INT")
    private Long id;

    @Column(name="codigo", nullable=false, unique=true)
    private String codigo;

    @Column(name="nombre", nullable=false)
    private String nombre;

    @Column(name="apellidos", nullable=false)
    private String apellido;

    //especial para claves foraneas
    @ManyToOne
    @JoinColumn(name="escuela_id", columnDefinition="INT" )
    private Escuela escuela;


}
