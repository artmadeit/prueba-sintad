package pe.sintad.prueba.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import pe.sintad.prueba.dto.TipoContribuyenteRequest;
import pe.sintad.prueba.entity.TipoContribuyente;

public interface TipoContribuyenteService {
    Page<TipoContribuyente> findAll(Pageable pageable);
    Optional<TipoContribuyente> findById(Long id);
    Long create(TipoContribuyenteRequest tipoContribuyenteRequest);
    Optional<TipoContribuyente> edit(Long id, TipoContribuyenteRequest tipoContribuyenteRequest);
    void delete(Long id);
}
