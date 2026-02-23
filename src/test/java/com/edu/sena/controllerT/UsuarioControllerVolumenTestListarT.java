package com.edu.sena.controllerT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.sena.controller.UsuarioController;
import com.edu.sena.models.entity.Usuario;

@SpringBootTest

public class UsuarioControllerVolumenTestListarT {
	
	@Autowired
	UsuarioController usuarioController;
	
	@Test
	public void testListarTodosVolumen() {
		int numeroRegistrosEsperados= 999;
		
		List<Usuario> usuarios = usuarioController.listarTodos();
			
		
		assertEquals(numeroRegistrosEsperados, usuarios.size());
		
	}
	
	

}
