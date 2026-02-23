package com.edu.sena.controllerT;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.sena.controller.UsuarioController;
import com.edu.sena.models.entity.Usuario;

@SpringBootTest


public class UsuarioControllerVolumenTestListar {
	
	@Autowired
	UsuarioController usuarioController;
	
	@Test
	public void testListarPorId() {
		int numeroRegistros = 1000;
		
		for (int i=1; i<numeroRegistros; i++) {
			Optional<Usuario> usuario= usuarioController.buscarPorId(i);

			assertTrue(usuario.isPresent());
			
			
			
			}
		
	}
	
	
	

}
