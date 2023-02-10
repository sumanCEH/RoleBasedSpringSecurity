package com.springsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springsecurity.service.CustomUserDetailsService;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailsService customerDetailsService;
	
	  @Autowired
	    private JwtAuthenticationFilter jwtFilter;

	    @Autowired
	    private JwtAuthenticationEntryPoint entryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.csrf().disable()
				.cors().disable()
				.authorizeRequests()
				.antMatchers("/public/**").permitAll()
				.antMatchers("/token").permitAll()
				.antMatchers(HttpMethod.OPTIONS).permitAll()
				.antMatchers("/employee/**").hasRole("EMPLOYEE")
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/customer/**").hasRole("CUSTOMER")
				.anyRequest()
				.authenticated()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	            .exceptionHandling().authenticationEntryPoint(entryPoint);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
			
		@Override
		protected void configure(AuthenticationManagerBuilder auth ) throws Exception{
			//auth.inMemoryAuthentication().withUser("admin").password(this.passwordEncoder().encode("admin")).roles("ADMIN");
			//auth.inMemoryAuthentication().withUser("employee").password(this.passwordEncoder().encode("employee")).roles("NORMAL");
			//auth.inMemoryAuthentication().withUser("customer").password(this.passwordEncoder().encode("employee")).roles("NORMAL");
			
			auth.userDetailsService(customerDetailsService).passwordEncoder(passwordEncoder());

		}
		
		@Bean
		public BCryptPasswordEncoder passwordEncoder(){
			return new BCryptPasswordEncoder(10);  
		}
		
		@Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
}

