package com.ecomm.security.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ecomm.security.utils.YamlPropertySourceFactory;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebMvc
@Slf4j
@PropertySource(value = "classpath:additional.yaml", factory = YamlPropertySourceFactory.class)
public class WebConfig implements WebMvcConfigurer{

    @Value("#{'${cors.allowed-origins}'.split(',')}")
    private String[] corsAllowedOrigins;
    @Value("#{'${cors.allowed-methods}'.split(',')}")
    private String[] corsAllowedMethods;
    @Value("#{'${cors.allowed-headers}'.split(',')}")
    private String[] corsAllowedHeaders;
    @Value("#{'${cors.exposed-headers}'.split(',')}")
    private String[] corsExposedHeaders;
    @Value("${cors.allow-credentials}")
    private boolean corsAllowCredentials;
    @Value("${cors.max-age}")
    private long corsMaxAge;
    @Value("${cors.path}")
    private String corsPath;
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.debug("Allowed Origins: " + corsAllowedOrigins);
        log.debug("Allowed Methods: " + corsAllowedMethods);
        log.debug("Allowed Headers: " + corsAllowedHeaders);
        log.debug("Exposed Headers: " + corsExposedHeaders);
        log.debug("Allow Credentials: " + corsAllowCredentials);
        log.debug("Max Age: " + corsMaxAge);
        log.debug("Path: " + corsPath);
        registry.addMapping(corsPath)
                .allowedOrigins(corsAllowedOrigins)
                .allowedMethods(corsAllowedMethods)
                .allowedHeaders(corsAllowedHeaders)
                .exposedHeaders(corsExposedHeaders)
                .allowCredentials(corsAllowCredentials)
                .maxAge(corsMaxAge);
    }

}
