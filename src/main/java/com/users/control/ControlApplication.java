package com.users.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
public class ControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlApplication.class, args);
    }


    //    Bean responsavél por mudar extensão da url para .xhtml se necessário.
    @Bean
    public ServletRegistrationBean facesServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean<>(new FacesServlet(), "*.xhtml");
        registration.setLoadOnStartup(1);
        registration.addUrlMappings("*.xhtml");
        return registration;
    }

    //    Bean responsavél por mapear contexto do servelet.
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        };
    }

    //  Blibioteca responsavel por fazer comunicação api rest
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}


