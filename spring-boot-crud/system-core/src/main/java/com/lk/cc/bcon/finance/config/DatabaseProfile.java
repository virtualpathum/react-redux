package com.lk.cc.bcon.finance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//TODO:Purpose of this class is to define the database profiles.
@Configuration
@Profile("dev")
public class DatabaseProfile {
	
/*	*//** The Constant jndiNamespace. *//*
	public static final String jndiNamespace = "java:comp/env/jdbc/bcon-finance";
	
	*//**
	 * Data source.
	 *
	 * @return the data source
	 * @throws NamingException the naming exception
	 *//*
	@Bean(initMethod = "init", destroyMethod = "close")
	public DataSource dataSource() throws NamingException {
		Context ctx = new InitialContext();
		return (DataSource) ctx.lookup(jndiNamespace);
	}*/
	
	

}
