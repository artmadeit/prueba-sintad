package pe.sintad.prueba.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import pe.sintad.prueba.dto.TipoDocumentoRequest;
import pe.sintad.prueba.entity.TipoDocumento;

public interface TipoDocumentoService {
    Page<TipoDocumento> findAll(Pageable pageable);
    Optional<TipoDocumento> findById(Long id);
    Long create(TipoDocumentoRequest tipoDocumentoRequest);
    Optional<TipoDocumento> edit(Long id, TipoDocumentoRequest tipoDocumentoRequest);
    void delete(Long id);
}
