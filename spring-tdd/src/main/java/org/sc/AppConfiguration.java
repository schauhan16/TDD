package org.sc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.sc")
public class AppConfiguration {
    
    @Bean
    public A getA(B b){
        return new A(b);
    }
}
