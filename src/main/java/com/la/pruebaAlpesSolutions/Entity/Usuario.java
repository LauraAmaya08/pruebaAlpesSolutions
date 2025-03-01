package com.la.pruebaAlpesSolutions.Entity;
import jakarta.persistence.*;

//Tabla y entidad usuarios

@Entity
@Table(name = "usuario")
public class Usuario {

    //Creación de un id autoincremental
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuarioNombre", nullable = false)
    private String usuarioNombre;

    @Column(name = "password")
    private String password;

    public Usuario(Integer id, String usuarioNombre, String password) {
        this.id = id;
        this.usuarioNombre = usuarioNombre;
        this.password = password;
    }

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
