package com.docencia.tareas.config;


import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.tareas.soap.TareaSoapService;

import jakarta.xml.ws.Endpoint;



@Configuration
public class CxfConfig {

    private final Bus bus;

    private final TareaSoapService tareaSoapEndPoint;

    public CxfConfig(Bus bus, TareaSoapService tareaSoapEndPoint)  {
        this.bus = bus;
        this.tareaSoapEndPoint = tareaSoapEndPoint;
    }

    @Bean
    public Endpoint helloEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, tareaSoapEndPoint);
        endpoint.publish("/tareas"); // Esto genera /services/tareas?wsdl
        return endpoint;
    }
}
