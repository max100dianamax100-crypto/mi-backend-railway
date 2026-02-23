package com.edu.sena.controllerT;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.sena.controller.UsuarioController;

@SpringBootTest


public class UsuarioControllerVolumenTestEliminar {
	
	@Autowired
	
	UsuarioController usuarioController;
	
	@Test
	public void testVolumenBorrar() {
		
		int numeroRegistros = 1000;
		for(int i=0; i<numeroRegistros; i++) {
			usuarioController.eliminar(i);
		}
	}
	

}
