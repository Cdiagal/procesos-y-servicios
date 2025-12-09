package es.ies.springboot.soap.service;

import org.springframework.stereotype.Service;

import es.ies.springboot.soap.service.interfaces.HelloServiceInterface;
import jakarta.jws.WebService;

@Service
@WebService(
    serviceName = "HelloService",
    portName = "HelloPort",
    targetNamespace = "http://jpexposito.es/ws/hello",
    endpointInterface = "es.ies.springboot.soap.service.HelloServiceInterface"
)

public class HelloService implements HelloServiceInterface{

    @Override
    public String sayHello(String name) {
        if(name == null || name.isBlank()){
            return "Hola desconocido";
        }
        return "Hola" + name + ", bienvenid@ a Apache CXF + String boot ";
    }

}
