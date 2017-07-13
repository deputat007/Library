package com.softjourn.practise.library.restservice.configuration;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource("classpath:security.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.securedURLPattern}")
    private String securedUrlPattern;

    @Value("${security.tokenHeaderName}")
    private String tokenHeaderName;

    @Bean
    public HexBinaryAdapter hexBinaryAdapter() {
        return new HexBinaryAdapter();
    }
}
