package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titulo;

    @Column
    private String isbn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="autor_id")
    private Autor autor;

    @ManyToMany(mappedBy = "libros")
    private List<Lector> lectores;


    public Libro() {
    }

    public Libro(int id, String titulo, String isbn, Autor autor, List<Lector> lectores) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.lectores = lectores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Lector> getLectores() {
        return lectores;
    }

    public void setLectores(List<Lector> lectores) {
        this.lectores = lectores;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                ", lectores=" + lectores +
                '}';
    }

}