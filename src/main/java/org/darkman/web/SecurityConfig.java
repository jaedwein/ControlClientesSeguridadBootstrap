package org.darkman.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Autowired public void configurerGlobal(AuthenticationManagerBuilder build)
	 * throws Exception {
	 * build.userDetailsService(userDetailsService).passwordEncoder(
	 * bCryptPasswordEncoder()); }
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/update/**", "/add/**", "/delete/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/").hasAnyRole("USER", "ADMIN").and().formLogin().loginPage("/login")
				.and().exceptionHandling().accessDeniedPage("/errores/403");
	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles(
	 * "ADMIN", "USER").and() .withUser("user").password("{noop}123").roles("USER");
	 * }
	 */

}
