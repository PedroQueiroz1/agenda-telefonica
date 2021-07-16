package br.com.freyr.controlador.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Criando um Bean que retorna uma Docket...
 */

/*
 * Por ter um Bean é necessário startar a classe com @Configuration para o Bean ser injetado
 * no contexto da aplicação.
 * Para poder ser consumido durante o tempo de execução.
 * 
 * Também é necessário habilitar o Swagger.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	// É necessário ter o Swagger 2 para encontrar o Docket !
	@Bean 
	public Docket configuracao() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select() //select para retornar o builder
				.apis(RequestHandlerSelectors.basePackage("br.com.freyr")) // Nome do pacote
				.build()
				.apiInfo(informacaoApi()); //Expondo informações da API com o método informacaoApi
	}
	
	//Método para o apiInfo -> para expor as informações da API
	private ApiInfo informacaoApi() {
		 return new ApiInfoBuilder()
				 .title("Agenda Telefônica")
				 .description("Sistema de agenda telefônica "
				 		+ "(pequeno projeto)</br></br>"
				 		+ " Utiliza as seguintes tecnologias:</br>"
				 		+ " - Swagger-ui + Swagger2</br>"
				 		+ " - Jaeger</br>"
				 		+ " - Actuator</br>"
				 		+ " - Flyway")
				 .version("1.0.0")
				 .build();
	}
}
