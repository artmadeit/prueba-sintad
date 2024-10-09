package pe.sintad.prueba.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import pe.sintad.prueba.dto.EntidadRequest;
import pe.sintad.prueba.entity.Entidad;

public interface EntidadService {
    Page<Entidad> findAll(Pageable pageable);
    Optional<Entidad> findById(Long id);
    Long create(EntidadRequest entidadRequest);
    Optional<Entidad> edit(Long id, EntidadRequest entidadRequest);
}
