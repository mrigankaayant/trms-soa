package com.ayantsoft.trms.auth.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@Import(Encoders.class)
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		System.out.println("configer AuthenticationManager ");
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.getDefaultUserDetailsService();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("configer WebSecurity ");
		web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
		//web.ignoring().antMatchers("/complete/payment/{username}");
		//web.ignoring().antMatchers("/cancel/payment");
	}
}
