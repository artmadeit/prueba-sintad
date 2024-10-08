package pe.sintad.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sintad.prueba.entity.TipoDocumento;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
}
