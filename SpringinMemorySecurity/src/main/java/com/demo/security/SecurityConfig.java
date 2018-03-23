package com.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	//Generating Encrypted Password
	/*public static void main(String args[]) {
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
	}*/

	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.inMemoryAuthentication()
		.withUser("mano")
		.password("$2a$10$aR9MYOxT7uWtvlB9K37mGeAnArs8sUGBFxe6/vn9aF6hz4SR52x46")
		.roles("ADMIN")
		.and()
		.passwordEncoder(new BCryptPasswordEncoder());
	
}
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http.csrf().disable().httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/name").hasAnyRole("ADMIN")
		.anyRequest().authenticated();
		
		
	}
		
	}

