package com.avaliacao3.states.apirest.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
                .apis(RequestHandlerSelectors.basePackage("com.avaliacao3.states.apirest"))
                .paths(PathSelectors.regex("/**"))
                .build();
                .apiInfo();
    }	
	

	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("API REST(Spring Boot)")
				.description( "Estados do Brasil e suas Regiões API REST.")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.version("1.0.0")
				.contact(new Contact("Dayana Ferreira", "https://www.linkedin.com/in/dayanaferreira0/"))
				.build();

		return apiInfo;
	
	}
}
