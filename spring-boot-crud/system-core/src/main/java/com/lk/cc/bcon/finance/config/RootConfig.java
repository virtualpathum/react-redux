package com.lk.cc.bcon.finance.config;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
//@Import({ SysConfig.class})
@ComponentScan(basePackages = { 
		"com.lk.cc.bcon.finance",
		"com.lk.cc.bcon.finance.service",
		"com.lk.cc.bcon.finance.web.controller",
		"com.lk.cc.bcon.finance.mapper" })
public class RootConfig {
	
	/**
	 * Jackson object mapper.
	 *
	 * @return the object mapper
	 */
	//Jackson mapper serialize Java objects into JSON and deserialize JSON string into Java objects 
	@Bean
	public ObjectMapper jacksonObjectMapper() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();

		builder.timeZone(TimeZone.getDefault());
		builder.serializationInclusion(Include.NON_NULL);
		builder.featuresToDisable(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		builder.featuresToEnable(
				DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		builder.defaultViewInclusion(Boolean.TRUE);

		return builder.build();
	}

}
