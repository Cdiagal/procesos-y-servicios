package com.docencia.tareas.repository;

import java.util.List;

import com.docencia.tareas.model.Tarea;

public interface ITareaRepository {

    /**
     * Documentar...
     * @param tarea
     * @return
     */
    public Tarea add(Tarea tarea);
    public boolean delete(Tarea tarea);
    public Tarea findBy(Tarea tarea);
    public Tarea update(Tarea tarea);
    public List<Tarea> findall();
}
