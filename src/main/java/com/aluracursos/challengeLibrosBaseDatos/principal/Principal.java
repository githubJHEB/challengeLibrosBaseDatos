package com.aluracursos.challengeLibrosBaseDatos.principal;

import com.aluracursos.challengeLibrosBaseDatos.modelos.Datos;
import com.aluracursos.challengeLibrosBaseDatos.modelos.DatosLibros;
import com.aluracursos.challengeLibrosBaseDatos.modelos.Libros;
import com.aluracursos.challengeLibrosBaseDatos.repository.LibrosRepository;
import com.aluracursos.challengeLibrosBaseDatos.service.ConsumoAPI;
import com.aluracursos.challengeLibrosBaseDatos.service.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final String URL_BASE = "https://gutendex.com/books/";
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();

    private LibrosRepository repositorio;

    public Principal(LibrosRepository repository) {
        this.repositorio = repository;
    }
    public void muestraEMenu() {

        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);

        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Almacenar libro por titulo 
                    2 - Buscar libro por titulo 
                    3 - Buscar libros regisrados
                    4 - Listar autores registrados
                    5 - Listar autores vivos en un determinado año
                    6 - Listar libros por idioma               
                    7 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    almacenarLibros();
                    break;
                case 2:
                    buscaLibroPorTitulo();
                    break;
                case 3:
                    buscaLibrosResgistrados();
                    break;
                case 4:
                    listarAutoresRegistrados();
                    break;
                case 5:
                    listarAutoresVivosDesde();
                    break;
                case 6:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void almacenarLibros() {
        System.out.println("Escriba el titulo del libro que desea almacenar en base de ddatos");
        var tituloLibro = teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(t -> t.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro almacenado ");
            System.out.println(libroBuscado.get());
        } else {
            System.out.println("Libro no disponibe en el proveedor");
        }
        Libros libros = new Libros(libroBuscado.get());
        libros.setAutor(libroBuscado.get().autor().get(0).nombre());
        libros.setIdiomas(libroBuscado.get().idiomas().get(0));
        libros.setFechaDeNacimiento(Integer.valueOf(libroBuscado.get().autor().get(0).fechaDeNacimiento()));
        repositorio.save(libros);
    }


    private void buscaLibroPorTitulo() {
        System.out.println("Escriba el titulo del libro a buscar");
        var tituloLibro = teclado.nextLine();
        List<Libros> libroBuscadoOnDataBase = repositorio.findByTituloContainsIgnoreCase(tituloLibro);

        if (libroBuscadoOnDataBase.isEmpty()) {
            System.out.println("Libro no encontrado en la base de datos");
        } else {
            libroBuscadoOnDataBase.forEach(System.out::println);
        }
    }

    private void buscaLibrosResgistrados() {
        System.out.println("Lista de todos los libros registrado en la base de datos");
        List<Libros> librosRegistrados = repositorio.findAll();
        System.out.println("Lista de libros registrados");
        librosRegistrados.forEach(l -> System.out.println("Titulo: " + l.getTitulo() + "\n" +
                "Autor: " + l.getAutor() + "\n" +
                "Idioma: " + l.getIdiomas() + "\n" +
                "Número de descargas: " + l.getNumeroDeDescargas() + "\n" +
                "---------------"));
    }

    private void listarAutoresRegistrados() {
        System.out.println("Lista de autores registrados");
        List<Libros> librosRegistrados = repositorio.findAll();
        librosRegistrados.stream()
                .sorted(Comparator.comparing(Libros::getAutor));
        librosRegistrados.forEach(l -> System.out.println(
                "Autor: " + l.getAutor()));
    }

    private void listarAutoresVivosDesde() {
        System.out.println("Por favor ingrese un años desde donde desea listar los autores registrados");
        var año = teclado.nextInt();
        List<Libros> libroBuscadoOnDataBase = repositorio.findByfechaDeNacimientoGreaterThanEqual(año);

        if (libroBuscadoOnDataBase.size() != 0) {
            libroBuscadoOnDataBase.forEach(l -> System.out.println("Titulo: " + l.getTitulo() + "\n" +
                    "Autor: " + l.getAutor() + "\n" +
                    "Idioma: " + l.getIdiomas() + "\n" +
                    "Número de descargas: " + l.getNumeroDeDescargas() + "\n" +
                    "---------------"));
        } else {
            System.out.println("Libro no encontrado en la base de datos");
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Por favor ingrese el idioma ");
        var idioma = teclado.nextLine();
        List<Libros> listarLibrosPorIdioma = repositorio.findByIdiomas(idioma);

        if (listarLibrosPorIdioma.isEmpty()) {
            System.out.println("No existen libros disponible en esta idioma");
        } else {
            listarLibrosPorIdioma.forEach(l -> System.out.println("Titulo: " + l.getTitulo() + "\n" +
                    "Autor: " + l.getAutor() + "\n" +
                    "Idioma: " + l.getIdiomas() + "\n" +
                    "Número de descargas: " + l.getNumeroDeDescargas() + "\n" +
                    "---------------"));
        }
    }
}
