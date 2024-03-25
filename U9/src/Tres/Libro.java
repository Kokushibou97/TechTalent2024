package Tres;

import Cuatro.Libro;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int numPaginas;

    // Constructor
    public Libro(String ISBN, String titulo, String autor, int numPaginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.numPaginas = numPaginas;
    }

    // Métodos get
    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    // Método toString (sobrescrito)
    @Override
    public String toString() {
        return "El libro con ISBN " + ISBN + " creado por " + autor + " tiene " + numPaginas + " páginas.";
    }

    public static void main(String[] args) {
        // Crear 2 objetos Libro
        Libro libro1 = new Libro("978-0061120084", "To Kill a Mockingbird", "Harper Lee", 281);
        Libro libro2 = new Libro("978-0307474278", "1984", "George Orwell", 328);

        // Mostrar información de los libros
        System.out.println(libro1);
        System.out.println(libro2);

        // Indicar cuál tiene más páginas
        if (libro1.getNumPaginas() > libro2.getNumPaginas()) {
            System.out.println(libro1.getTitulo() + " tiene más páginas.");
        } else {
            System.out.println(libro2.getTitulo() + " tiene más páginas.");
        }
    }
}

