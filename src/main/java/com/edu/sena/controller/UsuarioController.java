package com.edu.sena.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.sena.models.entity.Usuario;
import com.edu.sena.models.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // INDISPENSABLE: Permite que Vue (u otros) se conecten
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/{id}")
	public Optional<Usuario> buscarPorId(@PathVariable Integer id) {
		return usuarioService.findById(id);
	}	
	
	// CORRECCIÓN: Quitamos /{listar} para que la URL sea limpia: /api/usuarios
	@GetMapping
	public List<Usuario> listarTodos(){
		return usuarioService.findAll();
	}	
	
	@PostMapping
	public Usuario guardar(@RequestBody Usuario U) {
		return usuarioService.save(U);
	}

	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Integer id) {
		usuarioService.deletById(id);
	}
	
	// CORRECCIÓN: Agregamos "/" en la ruta y usamos orElse(null) para seguridad
	@PutMapping("/actualizar/{id}")
	public Usuario actualizar (@RequestBody Usuario U, @PathVariable Integer id) {
		Usuario UEnBD = usuarioService.findById(id).orElse(null);
		
		if (UEnBD != null) {
			UEnBD.setNombre(U.getNombre());
			UEnBD.setApellido(U.getApellido());
			UEnBD.setIdentificacion(U.getIdentificacion());
			return usuarioService.save(UEnBD);
		}
		return null;
	}
}
