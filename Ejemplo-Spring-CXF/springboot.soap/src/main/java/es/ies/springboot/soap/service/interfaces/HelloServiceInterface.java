package es.ies.springboot.soap.service.interfaces;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService(
    targetNamespace =  "http://jpexposito.es/ws/hello",
    name = "HelloPortType"
)
public interface HelloServiceInterface {

    @WebMethod(operationName = "sayHello")
    String sayHello(String name);

}
