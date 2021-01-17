package com.github.marcoslsouza.exemploapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
// Criar automaticamente as entidades
@EntityScan(basePackages = {"com.github.marcoslsouza.exemploapirest.model"})
// Configurar as injecoes de dependencias
@ComponentScan(basePackages = {"com.*"})
// Configurar os repositorios
@EnableJpaRepositories(basePackages = {"com.github.marcoslsouza.exemploapirest.repository"})
// Configurar transacoes
@EnableTransactionManagement
// Recursos de MVC (Apenas para demosntrar que podemos usar MVC)
@EnableWebMvc
// Habilitar Rest Controllers
@RestController
// Para ativar todas as configuracoes acima
@EnableAutoConfiguration
/*
 * 
 * WebMvcConfigurer para configurar o @CrossOrigin centralizado  
 */
public class ExemploApiRestApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ExemploApiRestApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Libera o servico /usuario/**, todos os metodos, para todas as urls acessarem.
		// Exemplo: allowedMethods("POST", "DELETE", "PUT")
		// Exemplo: allowedOrigins("www.teste1.com.br", "www.teste2.com.br")
		registry.addMapping("/usuario/**").allowedMethods("*").allowedOrigins("*");
	}
}
