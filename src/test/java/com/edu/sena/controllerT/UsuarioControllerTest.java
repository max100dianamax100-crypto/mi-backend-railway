package com.edu.sena.controllerT;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.edu.sena.controller.UsuarioController;
import com.edu.sena.models.entity.Usuario;
import com.edu.sena.models.service.UsuarioService;


@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {
	
	@InjectMocks
	private UsuarioController usuarioController;
	
	@Mock
	private UsuarioService usuarioService;
	
	@Test
	public void pruebaBuscarPorId() {
		
		Usuario usuarioSimulado = new Usuario();
		
		usuarioSimulado.setNombre("Eliza");
		usuarioSimulado.setApellido("Perez");
		usuarioSimulado.setIdentificacion(123456);
		
		
		//Configurar el comportamiento simulado de UsuarioService
		when(usuarioService.findById(1)).thenReturn(Optional.of(usuarioSimulado));
		
		//llamar al metodo del controlador que desea probar
		Optional<Usuario> resultado = usuarioController.buscarPorId(1);
		
		//Verifica que el resultado sea el esperado
		assertNotNull(resultado);
		assertTrue(resultado.isPresent());
		
		
	}
	
	@Test
	public void pruebaEliminar() {
		
		int Id=1;
		
		usuarioController.eliminar(1);
		
		verify(usuarioService, times(1)).deletById(Id);
		
		
	}
	
	@Test
	public void pruebaListarTodos() {
		
		Usuario usuario1 = new Usuario(2,"Lina","Gomez", 28);
		Usuario usuario2 = new Usuario(2,"Marfy","Murcia", 35);
		
		List<Usuario> listaUsuarios= new ArrayList<>();
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		
		when(usuarioService.findAll()).thenReturn(listaUsuarios);
		
		List<Usuario> resultado = usuarioController.listarTodos();
		
		assertNotNull(resultado);
		assertEquals(2,resultado.size());
		assertTrue(resultado.contains(usuario1));
		assertTrue(resultado.contains(usuario2));
		
		

		
	}
	
	@Test
	public void pruebaActualizar() {
		
		int Id=1;
		Usuario usuarioEnBd = new Usuario(Id,"Carolina","Marquin",22);
		Usuario usuarioActualizado = new Usuario(Id,"Marfy","Murcia",35);
		
		when(usuarioService.findById(Id)).thenReturn(Optional.of(usuarioEnBd));
		when(usuarioService.save(any(Usuario.class))).thenReturn(usuarioActualizado);
		
		Usuario resultado = usuarioController.actualizar(usuarioActualizado, Id);
		
		assertEquals("Marfy", resultado.getNombre());
		assertEquals("Murcia", resultado.getApellido());
		assertEquals(35, resultado.getIdentificacion());
		
		verify(usuarioService, times(1)).findById(Id);
		verify(usuarioService, times(1)).save(usuarioEnBd);
		
		
	}
		
	
	

}













