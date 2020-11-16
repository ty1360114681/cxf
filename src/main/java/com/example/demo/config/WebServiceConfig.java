package com.example.demo.config;

import com.example.demo.api.UserService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private UserService userService;

    @Bean(name=Bus.DEFAULT_BUS_ID)
    public SpringBus springBus(){
        return new SpringBus();
    }

    @Bean
    public Endpoint endpoint(){
        EndpointImpl endpointImpl = new EndpointImpl(bus, userService);
        endpointImpl.publish("/mes");
        return endpointImpl;
    }

}
