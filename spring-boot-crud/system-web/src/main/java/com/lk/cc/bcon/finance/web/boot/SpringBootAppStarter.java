package com.lk.cc.bcon.finance.web.boot;

import javax.inject.Inject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.lk.cc.bcon.finance.config.RootConfig;
import com.lk.cc.bcon.finance.web.controller.EmployeeController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Import({RootConfig.class})
@EnableSwagger2
@SpringBootApplication(scanBasePackages={"com.lk.cc.bcon.finance","com.lk.cc.bcon.finance.mapper"})
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages = "com.lk.cc.bcon.finance.repo")
@ComponentScan(basePackages = { 
		"com.lk.cc.bcon.finance",
		"com.lk.cc.bcon.finance.service",
		"com.lk.cc.bcon.finance.web.controller",
		"com.lk.cc.bcon.finance.mapper" })
public class SpringBootAppStarter{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	@Inject
	EmployeeController controller;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAppStarter.class, args);
	}
	
	//Swagger launch configurations
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
        		 .select()                 
        		 .apis(RequestHandlerSelectors.basePackage("com.lk.cc.bcon.finance.web.controller"))
                 .paths(PathSelectors.any())
                 .build();                                         
    }

}
