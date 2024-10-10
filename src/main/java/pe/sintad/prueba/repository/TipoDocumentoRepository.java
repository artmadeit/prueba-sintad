package pe.sintad.prueba.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.sintad.prueba.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {

    Page<TipoDocumento> findByNombreContains(String nombre, Pageable pageable);
}
