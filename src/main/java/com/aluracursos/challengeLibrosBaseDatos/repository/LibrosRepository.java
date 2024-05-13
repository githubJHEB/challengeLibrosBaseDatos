package com.aluracursos.challengeLibrosBaseDatos.repository;

import com.aluracursos.challengeLibrosBaseDatos.modelos.Libros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibrosRepository extends JpaRepository<Libros, Long> {

    List<Libros> findByTituloContainsIgnoreCase(String tituloDelLibro);

    List<Libros> findByfechaDeNacimientoGreaterThanEqual(Integer fechaDeNacimiento);

    List<Libros> findByIdiomas(String idioma);

}
