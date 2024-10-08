package pe.sintad.prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.sintad.prueba.entity.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {
}
