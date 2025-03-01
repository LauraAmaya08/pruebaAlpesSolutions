package com.la.pruebaAlpesSolutions.Controller;

import com.la.pruebaAlpesSolutions.Entity.Tarea;
import com.la.pruebaAlpesSolutions.Service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping("/todos")
    public ResponseEntity<List<Tarea>> obtenerTareas() {
        List<Tarea> tareas = tareaService.ListarTareas();
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/crear")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
        return ResponseEntity.ok(tareaService.crearTarea(tarea));
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTarea(@PathVariable Integer id) {
        tareaService.eliminarTarea(id);
    }

    @PatchMapping("/actualizar/{id}")
    public void actualizarTarea(@PathVariable Integer id, @RequestBody Tarea tareaActualizada) throws Exception {
        tareaService.actualizarTarea(id, tareaActualizada);
    }

}
