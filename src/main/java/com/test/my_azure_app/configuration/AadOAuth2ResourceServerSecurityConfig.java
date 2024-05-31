package com.test.my_azure_app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.azure.spring.cloud.autoconfigure.implementation.aad.security.AadResourceServerHttpSecurityConfigurer;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
@EnableMethodSecurity
public class AadOAuth2ResourceServerSecurityConfig {

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http.apply(AadResourceServerHttpSecurityConfigurer.aadResourceServer())
                .and()
            // All the paths that match `/api/**`(configurable) work as the resource server. Other paths work as the web application.
            .securityMatcher("/api/**")
            .authorizeHttpRequests()
                .anyRequest().authenticated();
        return http.build();
    }
}
