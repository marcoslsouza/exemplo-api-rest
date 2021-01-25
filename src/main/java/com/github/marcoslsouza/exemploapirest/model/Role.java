package com.github.marcoslsouza.exemploapirest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/*
 * Entidade que representa os papeis (permissoes) e acessos dos usuarios.
 */
@Entity
@Table(name = "role")
@SequenceGenerator(name = "seq_role", sequenceName = "seq_role", allocationSize = 1, initialValue = 1)
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 9212020578936709128L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
	private Long id;
	
	private String nomeRole; /* Papel, exemplo ROLE_SECRETARIO ou ROLE_GERENTE */

	// Retorna o nome do papel, acesso ou autorizacao exemplo ROLE_GERENTE
	@Override
	public String getAuthority() {
		
		return this.nomeRole;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}
}
