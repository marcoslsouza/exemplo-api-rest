package com.github.marcoslsouza.exemploapirest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.marcoslsouza.exemploapirest.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	// Terao pontos na aplicacao que iremos precisar recuperar apenas o login
	@Query("select u from Usuario u where u.login = ?1")
	Usuario findUserByLogin(String login);
}
