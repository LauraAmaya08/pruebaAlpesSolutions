package com.la.pruebaAlpesSolutions.Entity;
import com.la.pruebaAlpesSolutions.Entity.Enum.Estado;
import jakarta.persistence.*;


//Creación de la entidad y tabla tarea

@Entity
@Table(name = "tarea")
public class Tarea {

    //Creación de un id autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Estado estado;


    //Constructores del objeto

    public Tarea(Integer id, String titulo, String descripcion, Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Tarea() {
    }

    // Getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
