package main.com.myApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc

public class WebConfigMvc extends WebMvcConfigurerAdapter {
    @Override
    public  void addResourceHandlers(ResourceHandlerRegistry register){
        register.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

    }
}
