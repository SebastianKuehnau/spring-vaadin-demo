package com.example;

import org.atmosphere.cpr.SessionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.support.ApplicationContextEventBroker;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {

	@Autowired
    EventBus.ApplicationEventBus applicationEventBus;

    /**
     * Forward {@link org.springframework.context.ApplicationEvent}s to the {@link org.vaadin.spring.events.EventBus.ApplicationEventBus}.
     */
    @Bean
    ApplicationContextEventBroker applicationContextEventBroker() {
        return new ApplicationContextEventBroker(applicationEventBus);
    }

    @Bean
    public SessionSupport atmosphereSessionSupport() {
        return new SessionSupport();
    }
    
    public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
    }
}
