package com.github.marcoslsouza.exemploapirest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.github.marcoslsouza.exemploapirest.model.Usuario;
import com.github.marcoslsouza.exemploapirest.repository.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Consultar no banco o usuario.
		// findUserByLogin metodo criado em UsuarioRepository
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		if(usuario == null)
			throw new UsernameNotFoundException("Usuário não foi encontrado!");
		
		// User classe do spring.
		// A classe Usuario implementa UserDetails.
		return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
	}

}
