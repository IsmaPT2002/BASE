import entities.Autor;
import entities.Lector;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();


        //añadir un libro
        em.getTransaction().begin();
        Libro libro = new Libro();
        libro.setTitulo("El Quijote");
        libro.setIsbn("123456789");
        Autor autor = new Autor();
        autor.setNombre("Jorge");
        autor.setNacionalidad("Española");
        Lector lector = new Lector();
        lector.setNombre("Pepe");
        lector.setApellido("Pérez");
        libro.setAutor(autor);
        libro.setLectores(List.of(lector));
        em.persist(libro);
        autor.setLibros(List.of(libro));
        em.persist(autor);
        lector.setLibros(List.of(libro));
        em.persist(lector);
        em.getTransaction().commit();

        //mostrar los libros de un lector
        System.out.println("Los libros de " + lector.getNombre() + " son:");
        for (Libro l : lector.getLibros()) {
            System.out.println(l.getTitulo());
        }

        //mostrar los lectores de un libro
        System.out.println("Los lectores de " + libro.getTitulo() + " son:");
        for (Lector l : libro.getLectores()) {
            System.out.println(l.getNombre());
        }

        //mostrar todos los libros de un autor
        System.out.println("Los libros de " + autor.getNombre() + " son:");
        for (Libro l : autor.getLibros()) {
            System.out.println(l.getTitulo());
        }

        //mostrar el autor de un libro
        System.out.println("El autor de " + libro.getTitulo() + " es " + libro.getAutor().getNombre());
    }

}
