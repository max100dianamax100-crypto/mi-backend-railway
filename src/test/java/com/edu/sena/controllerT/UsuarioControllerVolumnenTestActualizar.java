package com.edu.sena.controllerT;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edu.sena.controller.UsuarioController;
import com.edu.sena.models.entity.Usuario;

@SpringBootTest


public class UsuarioControllerVolumnenTestActualizar {
	
		@Autowired
	
		UsuarioController usuarioController;
	
		@Test
		public void testActualizarVolumen() {
		
		int numeroRegistros = 1000;
		
		List<Usuario> usuarios= new ArrayList<>();
		
		
		for(int i=0; i<numeroRegistros; i++) {
			Usuario usuario = new Usuario();
			
			usuario.setIdentificacion(i);
			usuario.setNombre("Nombre" + i);
			usuario.setApellido("Apellido" + i);
			
			usuarios.add(usuario);
		
			
		
		}
		
		usuarios.forEach(usuario-> usuarioController.guardar(usuario));
		
		for(int i=0; i<numeroRegistros; i++) {
			
			Optional<Usuario> usuarioAct = usuarioController.buscarPorId(i);
			if (usuarioAct.isPresent()) {
				
				Usuario usuario = usuarioAct.get();
				usuario.setNombre("Nombre Actualizado" + i);
				usuarioController.guardar(usuario);
				
				
			}
			
		}
		for(int i=0; i<numeroRegistros; i++) {
				
			Optional<Usuario> usuarioAct = usuarioController.buscarPorId(i);
			if (usuarioAct.isPresent()) {
					
				Usuario usuario = usuarioAct.get();
				assertEquals("Nombre Actualizado" + i, usuario.getNombre() );
				
				
							
			
			}
		}
	
	
	}
		
}
	


