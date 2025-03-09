package com.exa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	   @Bean
	   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        
	    	 http.csrf().disable()
	    	  .authorizeHttpRequests().requestMatchers("/users/**").hasRole("USER")
	    	  .requestMatchers("/**").permitAll().and()
	    	   .formLogin().loginPage("/login")
	    	  .loginProcessingUrl("/userlogin")
	    	  .defaultSuccessUrl("/user/addnotes").permitAll();
	    	/*http.csrf().disable().authorizeHttpRequests().requestMatchers("/user/**").hasRole("USER")
	    	.requestMatchers("/admin/**").hasRole("ADMIN").
	    	requestMatchers("/**").permitAll().and().formLogin().loginPage("/login")
	    	.loginProcessingUrl("/userlogin").successHandler(successHandler)
	    	.permitAll();*/
	    
	             return http.build();
	    }
	

}
