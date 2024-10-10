package pe.sintad.prueba.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.sintad.prueba.dto.EntidadRequest;
import pe.sintad.prueba.entity.Entidad;
import pe.sintad.prueba.repository.EntidadRepository;
import pe.sintad.prueba.repository.TipoContribuyenteRepository;
import pe.sintad.prueba.repository.TipoDocumentoRepository;
import pe.sintad.prueba.service.EntidadService;

@Service
@AllArgsConstructor
public class EntidadServiceImpl implements EntidadService {
    TipoDocumentoRepository tipoDocumentoRepository;
    TipoContribuyenteRepository tipoContribuyenteRepository;
    EntidadRepository entidadRepository;

    @Override
    public Page<Entidad> findAll(Pageable pageable) {
        return entidadRepository.findAll(pageable);
    }

    @Override
    public Optional<Entidad> findById(Long id) {
        return entidadRepository.findById(id);
    }

    @Override
    @Transactional
    public Long create(EntidadRequest entidadRequest) {
        var entidad = toModel(entidadRequest, new Entidad());
        entidad = entidadRepository.save(entidad);
        return entidad.getId();
    }

    @Override
    @Transactional
    public Optional<Entidad> edit(Long id, EntidadRequest entidadRequest) {
        return this.entidadRepository.findById(id).map(entidad -> {
            toModel(entidadRequest, entidad);
            return entidadRepository.save(entidad);
        });
    }

    // TODO: we can move this to a mapper
    private Entidad toModel(EntidadRequest entidadRequest, Entidad entidad) {
        entidad.setTipoDocumento(tipoDocumentoRepository.getOne(entidadRequest.getTipoDocumentoId()));
        entidad.setNroDocumento(entidadRequest.getNroDocumento());
        entidad.setRazonSocial(entidadRequest.getRazonSocial());
        entidad.setNombreComercial(entidadRequest.getNombreComercial());
        entidad.setTipoContribuyente(tipoContribuyenteRepository.getOne(entidadRequest.getTipoContribuyenteId()));
        entidad.setDireccion(entidadRequest.getDireccion());
        entidad.setTelefono(entidadRequest.getTelefono());
        return entidad;
    }

    @Override
    public void delete(Long id) {
        this.entidadRepository.deleteById(id);
    }

}
