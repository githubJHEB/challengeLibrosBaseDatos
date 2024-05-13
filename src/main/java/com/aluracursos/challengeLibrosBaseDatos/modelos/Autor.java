package com.aluracursos.challengeLibrosBaseDatos.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;


public class Autor {


    private Long Id;

    String nombre;
    String fechaDeNacimiento;
}
