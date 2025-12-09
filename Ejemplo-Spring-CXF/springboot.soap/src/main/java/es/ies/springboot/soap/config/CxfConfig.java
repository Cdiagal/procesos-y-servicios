package es.ies.springboot.soap.config;

import es.ies.springboot.soap.service.HelloService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    private final Bus bus;

    public CxfConfig(Bus bus) {
        this.bus = bus;
    }

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new HelloService());
        endpoint.publish("/hello"); // Esto genera /services/hello?wsdl
        return endpoint;
    }
}
