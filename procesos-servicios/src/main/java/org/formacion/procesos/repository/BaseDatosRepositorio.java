package org.formacion.procesos.repository;

import org.formacion.procesos.repository.interfaces.IFicheroRepository;
import org.springframework.stereotype.Repository;

@Repository("baseDatosRepositorio")
public class BaseDatosRepositorio implements IFicheroRepository {
    @Override
    public String saludar() {
        return "Te estoy saludando desde el repositorio de base datos";
    }
}
