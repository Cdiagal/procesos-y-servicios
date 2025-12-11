package com.docencia.tareas.soap;

import java.util.List;

import com.docencia.tareas.model.Alumno;

import jakarta.jws.*;

@WebService(
        targetNamespace =  "http://ies.puerto.es/ws/alumnos",
        name = "AlumnoPortType"
    )

public interface IAlumnoSoapEndPoint {

    @WebMethod(operationName = "listar")
    List<Alumno> listar();
}
