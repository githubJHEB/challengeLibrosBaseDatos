package com.aluracursos.challengeLibrosBaseDatos;

import com.aluracursos.challengeLibrosBaseDatos.modelos.Libros;
import com.aluracursos.challengeLibrosBaseDatos.principal.Principal;
import com.aluracursos.challengeLibrosBaseDatos.repository.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLibrosBaseDatosApplication implements CommandLineRunner {

	@Autowired //Inyecion de dependencia
	private LibrosRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLibrosBaseDatosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraEMenu();

	}
}
