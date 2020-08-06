package com.skynet.bootstrap;

import com.terapico.uccaf.UCInvocationServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, RestClientAutoConfiguration.class, KafkaAutoConfiguration.class})
@ImportResource(locations = {"classpath:/META-INF/spring.xml", "classpath:/META-INF/online-system.xml"})
@ServletComponentScan(basePackageClasses = {UCInvocationServlet.class})
public class AppEntrance {
    public static void main(String[] args) {
        SpringApplication.run(AppEntrance.class, args);
    }

    @Bean
    public FilterRegistrationBean requestWrapperFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ContentCachingRequestWrapperFilter());
        registration.addUrlPatterns("/*");
        registration.setName("requestWrapperRequest");
        registration.setOrder(HIGHEST_PRECEDENCE);
        return registration;
    }

    public class ContentCachingRequestWrapperFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            MultiReadHttpServletRequest requestWrapper = new MultiReadHttpServletRequest(request);
            filterChain.doFilter(requestWrapper, response);
        }
    }

}
