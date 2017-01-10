package io.git;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import io.git.models.gpb.CountryGBPRepository;
import io.git.models.gpb.CountryProtos;

@SpringBootApplication
@EnableJpaRepositories
public class Application {

	@Bean
	public ServletRegistrationBean h2servletRegistration() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
	    registration.addUrlMappings("/console/*");
	    return registration;
	}
	
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    private CountryProtos.Country country(String country, String capital, String continent, String locale) {
        return CountryProtos.Country.newBuilder()
                .setCountry(country)
                .setCapital(capital)
                .setContinent(continent)
                .setLocale(locale)
                .build();
    }
    
    @Bean
    CountryGBPRepository GBPRepository() {
		return null;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
