package com.docencia.tareas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.jmx.export.assembler.AbstractConfigurableMBeanInfoAssembler;

import com.docencia.tareas.model.Alumno;
import com.docencia.tareas.model.Tarea;

@Mapper
public interface TareaMapper {

    TareaMapper INSTANCE = Mappers.getMapper(TareaMapper.class);

    /**
     * que se quiere devolver? Un alumno...
     * Se le pasa una tarea
     * source = origen y target destino
     */
    
    @Mappings({
    @Mapping(source = "id" , target = "identificador"),
    @Mapping(source = "titulo" , target = "nombre"),
    })
    Alumno toAlumno(Tarea tarea);

    List<Alumno> toAlumnos(List<Tarea> tareas);
}
