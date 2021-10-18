package com.impos.pmv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.impos.pmv.security.JWTAuthorizationFilter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests().antMatchers(HttpMethod.POST, "/token").permitAll()

					
					.antMatchers(HttpMethod.PUT, "/usuario").hasRole("ADMIN")
					.antMatchers(HttpMethod.POST, "/usuario").hasRole("ADMIN")

					.antMatchers(HttpMethod.POST, "/categoria").hasAnyRole("ADMIN", "USER")
					.antMatchers(HttpMethod.POST, "/producto").hasAnyRole("ADMIN", "USER")

					.antMatchers(HttpMethod.GET, "/categoria").hasAnyRole("ADMIN", "USER")
					.antMatchers(HttpMethod.GET, "/producto").hasAnyRole("ADMIN", "USER")
					.antMatchers(HttpMethod.GET, "/usuario").hasRole("ADMIN")

					.antMatchers(HttpMethod.PUT, "/categoria").hasAnyRole("ADMIN", "USER")
					.antMatchers(HttpMethod.PUT, "/producto").hasAnyRole("ADMIN", "USER")

					.anyRequest().authenticated();
		}

	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
