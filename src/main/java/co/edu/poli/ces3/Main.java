package co.edu.poli.ces3;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import models.Libro;
import models.Subject;

import java.io.*;
import java.util.*;

public class Main {
    public Main() {
    }

    public static void imprimirBuscarLibrosPorPrecio(List<Libro> listaLibros,double dPrecio){
        for(Libro oLibro : listaLibros){
            if(oLibro.getPrecio() == dPrecio){
                System.out.println("El libro : " + oLibro.getTitulo() + " tiene el precio a buscar (" + dPrecio + ")");
            }
        }
    }

    public static void imprimirAutoresDistintos(List<Libro> listaLibros){
        Map<String,Subject> mapAutores = new HashMap<String,Subject>();
        for(Libro oLibro : listaLibros){
            List<Subject> listaAutores = oLibro.getAutores();
            if(listaAutores != null){
                for(Subject autor : listaAutores){
                    if(!mapAutores.containsKey(autor.getCedula())){
                        System.out.println("Cédula : " + autor.getCedula() + ", Nombre :" + autor.getNombre());
                        mapAutores.put(autor.getCedula(),autor);
                    }
                }
            }
        }
    }

    public static void imprimirOrdenadoPorTitulo(List<Libro> listaLibros){
        Collections.sort(listaLibros,new Comparator<Libro>(){
            public int compare(Libro s1,Libro s2){
                return s1.getTitulo().compareTo(s2.getTitulo());
            }});

        for(Libro oLibro : listaLibros){
            System.out.println("******************************************************************************");
            System.out.println("Libro con titulo: " + oLibro.getTitulo());
            System.out.println("Año: " + oLibro.getAnio());
            List<Subject> lista = oLibro.getAutores();
            if(lista != null){
                for(Subject autor : lista){
                    System.out.println("Autor: " + autor.getNombre());
                }
            }
        }
    }

    public static void main(String[] args) {
        try {

            ObjectMapper mapper = new XmlMapper();

            InputStream inputStream = new FileInputStream( new File("src\\resources\\Libro.xml"));

            TypeReference <List<Libro>> typeReference = new TypeReference<List <Libro>>(){};
            List<Libro> listaLibros = mapper.readValue(inputStream,typeReference);

            //Llamar los métodos
            System.out.println("Imprimir libros que tienen el precio 39.95");
            System.out.println("*******************************************");
            imprimirBuscarLibrosPorPrecio(listaLibros,39.95);
            System.out.println("*******************************************");

            System.out.println("Imprimir los distintos autores");
            System.out.println("*******************************************");
            imprimirAutoresDistintos(listaLibros);
            System.out.println("*******************************************");

            System.out.println("Imprimir los libros ordenados por título");
            imprimirOrdenadoPorTitulo(listaLibros);
            System.out.println("GRACIAS");
        }catch (IOException e){


            System.out.println(e.getMessage());
        }

    }
}
