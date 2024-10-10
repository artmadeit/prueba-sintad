package pe.sintad.prueba.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import pe.sintad.prueba.entity.TipoContribuyente;

public interface TipoContribuyenteRepository extends JpaRepository<TipoContribuyente, Long> {

    Page<TipoContribuyente> findByNombreContains(String nombre, Pageable pageable);
}
