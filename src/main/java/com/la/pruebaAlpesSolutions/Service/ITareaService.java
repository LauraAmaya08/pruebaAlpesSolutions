package com.la.pruebaAlpesSolutions.Service;

import com.la.pruebaAlpesSolutions.Entity.Tarea;

import java.util.List;

public interface ITareaService {
    public Tarea crearTarea(Tarea tarea);
    public void eliminarTarea(Integer idTarea);
    public List<Tarea> ListarTareas();
    public Tarea actualizarTarea(Integer IdTarea, Tarea tareaActualizada) throws Exception;
}
