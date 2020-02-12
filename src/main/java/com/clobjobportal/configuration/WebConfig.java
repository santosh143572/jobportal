package com.clobjobportal.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/css/**",
                "/doc/**",
                "/fonts/**",
                "/img/**",
                "/js/**",
                "/scss/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/css/",
                        "classpath:/static/doc/",
                        "classpath:/static/fonts/",
                        "classpath:/static/img/",
                        "classpath:/static/js/",
                        "classpath:/staticscss/");
    }

}