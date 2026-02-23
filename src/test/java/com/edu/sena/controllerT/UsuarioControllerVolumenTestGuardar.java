package com.edu.sena.controllerT;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.sena.controller.UsuarioController;
import com.edu.sena.models.entity.Usuario;

@SpringBootTest


public class UsuarioControllerVolumenTestGuardar {
	
		@Autowired
		
		UsuarioController usuarioController;
		
		@Test
		public void TestGuardarEstudianteVolume() {
		
			
		int numeroRegistros = 1000;
		
		List<Usuario> usuarios = new ArrayList<>();
		for(int i=0; i<numeroRegistros; i++) {
			
			Usuario usuario = new Usuario();
			usuario.setId(i);
			usuario.setIdentificacion(i);
			usuario.setApellido("Apellido"+i);
			usuario.setNombre("Nombre" + i);
			
			
				
		
			usuarios.add(usuario);
			
			
			
			
		}
		
		usuarios.forEach(estudiante-> usuarioController.guardar(estudiante));
			
		}
		

}
