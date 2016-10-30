package com.nikitab.config

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		HttpMessageConverter<?> foundConverter = converters.find { converter -> converter instanceof AbstractJackson2HttpMessageConverter }
		if (foundConverter) {
			AbstractJackson2HttpMessageConverter jacksonConverter = foundConverter as AbstractJackson2HttpMessageConverter
			jacksonConverter.objectMapper.enable(SerializationFeature.INDENT_OUTPUT)
			jacksonConverter.objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)

		}
	}
}
