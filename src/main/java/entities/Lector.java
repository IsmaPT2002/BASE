package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Lectores")
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @ManyToMany
    @JoinTable(name = "Lectores_Libros",
            joinColumns = @JoinColumn(name = "lector_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id"))
    private List<Libro> libros;

    public Lector() {
    }

    public Lector(int id, String nombre, String apellido, List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.libros = libros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", libros=" + libros +
                '}';
    }
}
