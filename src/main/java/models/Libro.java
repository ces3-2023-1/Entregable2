package models;

import java.util.List;

public class Libro implements Comparable{
    String titulo;
    String Editorial;
    double precio;

    String centro;
    Object autor;
    String anio;

    String codigoPais;
    private String editorial;

    List<Subject> autores;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String editorial) {
        Editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public Object getAutor() {
        return autor;
    }

    public void setAutor(Object autor) {
        this.autor = autor;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public List<Subject> getAutores() {
        return autores;
    }

    public void setAutores(List<Subject> autores) {
        this.autores = autores;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    @Override
    public int compareTo(Object o) {
        return this.getTitulo().compareTo(((Libro)o).getTitulo());
    }
}
