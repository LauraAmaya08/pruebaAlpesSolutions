package com.la.pruebaAlpesSolutions.Repository;

import com.la.pruebaAlpesSolutions.Entity.Enum.Estado;
import com.la.pruebaAlpesSolutions.Entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    Optional<Tarea> findByEstado(Estado estado);
}
