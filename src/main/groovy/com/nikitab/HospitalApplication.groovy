package com.nikitab

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.DispatcherServlet

@SpringBootApplication
@Configuration
class HospitalApplication extends SpringBootServletInitializer {

	@Bean
	DispatcherServlet dispatcherServlet() {
		new DispatcherServlet()
	}

	@Bean
	ServletRegistrationBean dispatcherServletRegistration() {
		final ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(), "/*")
		Map<String, String> params = new HashMap<>()
		params << ["contextClass" : "org.springframework.context.annotation.AnnotationConfigApplicationContext"]
		params << ["dispatchOptionsRequest": "true"]
		registration.setInitParameters(params)
		registration.setLoadOnStartup(1)
		registration
	}

	static void main(String[] args) {
		SpringApplication.run HospitalApplication, args
	}
}
