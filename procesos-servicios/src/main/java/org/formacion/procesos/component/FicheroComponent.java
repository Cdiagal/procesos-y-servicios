package org.formacion.procesos.component;

import org.formacion.procesos.component.interfaces.IFicheroComponent;
import org.formacion.procesos.repository.interfaces.IFicheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FicheroComponent implements IFicheroComponent {
    @Autowired
    @Qualifier("baseDatosRepositorio")
    IFicheroRepository baseDatosRepositorio;

    @Autowired
    @Qualifier("ficheroRepositorio")
    IFicheroRepository ficheroRepository;

    @Override
    public String mensaje() {
        return ficheroRepository.saludar()+ " "+baseDatosRepositorio.saludar();
    }

    //Debe tener la responsabilidad de validar si el comando es correcto o no con uno o varios metodos.
}
