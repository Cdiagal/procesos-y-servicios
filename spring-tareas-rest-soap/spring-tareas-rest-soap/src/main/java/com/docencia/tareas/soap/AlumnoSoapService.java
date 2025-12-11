package com.docencia.tareas.soap;

import java.util.List;

import com.docencia.tareas.model.Alumno;
import com.docencia.tareas.service.IAlumnoService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import jakarta.jws.WebService;

@WebService(
    serviceName = "AlumnoService",
    portName = "AlumnoPort",
    targetNamespace = "http://ies.puerto.es/ws/alumnos",
    endpointInterface = "com.docencia.tareas.soap.IAlumnoSoapEndPoint"
)

public class AlumnoSoapService implements IAlumnoSoapEndPoint{


    private final IAlumnoService alumnoService;

    public AlumnoSoapService(IAlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @Override
    public List<Alumno> listar() {
        return alumnoService.listarTodas();
    }

}
