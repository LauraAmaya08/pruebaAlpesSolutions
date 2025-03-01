package com.la.pruebaAlpesSolutions.Service;

import com.la.pruebaAlpesSolutions.Entity.Tarea;
import com.la.pruebaAlpesSolutions.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements ITareaService{
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Integer idTarea) {
        Tarea tareaEliminar = tareaRepository.findById(idTarea).orElse(null);
        if (tareaEliminar != null){
            tareaRepository.delete(tareaEliminar);
        }
    }

    @Override
    public List<Tarea> ListarTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea actualizarTarea(Integer idTarea, Tarea tareaActualizada) throws Exception {
        Tarea tareaExistente = tareaRepository.findById(idTarea).orElseThrow(() -> new Exception("Tarea no encontrada con id: " + idTarea));

        if (tareaExistente == null) {
            throw new IllegalArgumentException("La info proporcionada no puede ser nula");
        }
        tareaExistente.setDescripcion(tareaActualizada.getDescripcion());
        tareaExistente.setEstado(tareaActualizada.getEstado());
        tareaExistente.setTitulo(tareaActualizada.getTitulo());
        return tareaRepository.save(tareaExistente);
    }
}
