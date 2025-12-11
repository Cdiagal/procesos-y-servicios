package com.docencia.tareas.config;


import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.tareas.soap.AlumnoSoapService;
import com.docencia.tareas.soap.TareaSoapService;

import jakarta.xml.ws.Endpoint;



@Configuration
public class CxfConfig {

    private final Bus bus;

    private final TareaSoapService tareaSoapEndPoint;

     private final AlumnoSoapService alumnoSoapEndPoint;

    public CxfConfig(Bus bus, TareaSoapService tareaSoapEndPoint, AlumnoSoapService alumnoSoapEndPoint)  {
        this.bus = bus;
        this.tareaSoapEndPoint = tareaSoapEndPoint;
        this.alumnoSoapEndPoint = alumnoSoapEndPoint;
    }

    @Bean
    public Endpoint tareasEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, tareaSoapEndPoint);
        endpoint.publish("/tareas"); // Esto genera /services/tareas?wsdl
        return endpoint;
    }

    @Bean
    public Endpoint alumnosEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, alumnoSoapEndPoint);
        endpoint.publish("/alumnos"); // Esto genera /services/tareas?wsdl
        return endpoint;
    }
}
