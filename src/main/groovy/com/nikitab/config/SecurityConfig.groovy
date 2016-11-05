package com.nikitab.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService

	@Bean
	PasswordEncoder passwordEncoder() {
		new BCryptPasswordEncoder()
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder())
	}

	@Override
	void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("favicon.ico")
		web.ignoring().antMatchers("/resources/**")
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
					.anyRequest().authenticated()
					.and()
				.formLogin()
					.defaultSuccessUrl("/api")
					.and()
				.logout()
					.logoutUrl("/logout")
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))//this here lets logout with GET request(but it is not recommended)
	}
}
