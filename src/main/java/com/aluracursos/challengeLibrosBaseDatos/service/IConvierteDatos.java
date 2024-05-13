package com.aluracursos.challengeLibrosBaseDatos.service;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
