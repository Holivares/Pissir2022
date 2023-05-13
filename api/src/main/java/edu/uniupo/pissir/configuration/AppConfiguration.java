package edu.uniupo.pissir.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
@EnableJpaRepositories( basePackages = { "edu.uniupo.pissir.repository" }, enableDefaultTransactions = false, bootstrapMode = BootstrapMode.DEFERRED )
public class AppConfiguration {

    @Bean
    public FilterRegistrationBean<Filter> corsFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter( filter() );
        filterRegistrationBean.addUrlPatterns( "/*" );
        filterRegistrationBean.setName( "corsFilter" );
        filterRegistrationBean.setOrder( 1 );
        return filterRegistrationBean;
    }

    @Bean
    public Filter filter(){
        return ( request, response, chain ) -> {
            HttpServletResponse servletResponse = ( HttpServletResponse ) response;
            servletResponse.setHeader( "Access-Control-Allow-Origin", "http://localhost:63342" );
            servletResponse.setHeader( "Access-Control-Allow-Credentials", "true" );
            servletResponse.setHeader( "Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH" );
            servletResponse.setHeader( "Access-Control-Max-Age", "3600" );
            servletResponse.setHeader( "Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers" );
            chain.doFilter( request, response );
        };
    }
}
