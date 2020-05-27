package com.example.springboot;

import java.lang.annotation.Annotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.annotations.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringbootjavabrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootjavabrainApplication.class, args);
		System.out.println(" Application started");
		System.out.println("i am in master branch");
		System.out.println("i am in develop branch");
	}
	public static final Contact DEFAULT_CONTACT = new Contact() {
		
		@Override
		public Class<? extends Annotation> annotationType() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String url() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String name() {
			// TODO Auto-generated method stub
			return "SARVAJIT";
		}
		
		@Override
		public String email() {
			// TODO Auto-generated method stub
			return "saha.sarvajit@gmail.com";
		}
	};
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo( "Awesome Api Title", "Awesome API description", "1.0", "urn:tos", "default", 
			"Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.springboot"))
				
				.build();
	}

}
