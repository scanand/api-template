package com.soagile.api.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by BMGTS on 24/02/2016.
 */
@Configuration
@ComponentScan(basePackages = {"com.soagile.api.web.*", "com.soagile.api.common.model", "com.soagile.api.service.*"})
@EnableWebMvc
public class WebappConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        final PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        return pspc;
    }
}
