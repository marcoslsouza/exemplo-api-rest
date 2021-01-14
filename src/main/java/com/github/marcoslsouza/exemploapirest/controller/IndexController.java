package com.github.marcoslsouza.exemploapirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.marcoslsouza.exemploapirest.model.Usuario;
import com.github.marcoslsouza.exemploapirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping(value = "/", produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Usuario> init(@RequestBody Usuario usuario) {
		//Usuario usuario = new Usuario();
		//usuario.setLogin("maria.souza@gmail.com");
		//usuario.setNome("Maria");
		//usuario.setSenha("12355");
		
		usuarioRepository.save(usuario);
		
		return ResponseEntity.ok(usuario);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public Usuario buscar(@PathVariable(value = "id") Long id) {
		
		return usuarioRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
	}
	
	@GetMapping(value = "/", produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public Iterable<Usuario> buscarTodos() {
		
		return usuarioRepository.findAll();
	}
}
