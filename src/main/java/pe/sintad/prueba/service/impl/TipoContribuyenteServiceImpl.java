package pe.sintad.prueba.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.sintad.prueba.dto.TipoContribuyenteRequest;
import pe.sintad.prueba.entity.TipoContribuyente;
import pe.sintad.prueba.repository.TipoContribuyenteRepository;
import pe.sintad.prueba.service.TipoContribuyenteService;

@Service
@AllArgsConstructor
public class TipoContribuyenteServiceImpl implements TipoContribuyenteService {

    TipoContribuyenteRepository tipoContribuyenteRepository;

    @Override
    public Page<TipoContribuyente> findAll(Pageable pageable) {
        return tipoContribuyenteRepository.findAll(pageable);
    }

    @Override
    public Optional<TipoContribuyente> findById(Long id) {
        return tipoContribuyenteRepository.findById(id);
    }

    @Override
    @Transactional
    public Long create(TipoContribuyenteRequest tipoContribuyenteRequest) {
        var tipoContribuyente = toModel(tipoContribuyenteRequest, new TipoContribuyente());
        tipoContribuyente = tipoContribuyenteRepository.save(tipoContribuyente);
        return tipoContribuyente.getId();

    }

    @Override
    public Optional<TipoContribuyente> edit(Long id, TipoContribuyenteRequest tipoContribuyenteRequest) {
        return tipoContribuyenteRepository.findById(id).map(tipoContribuyente -> {
            toModel(tipoContribuyenteRequest, tipoContribuyente);
            return tipoContribuyenteRepository.save(tipoContribuyente);
        });
    }

    private TipoContribuyente toModel(TipoContribuyenteRequest tipoContribuyenteRequest,
            TipoContribuyente tipoContribuyente) {
        tipoContribuyente.setNombre(tipoContribuyenteRequest.getNombre());
        return tipoContribuyente;
    }

    @Override
    public void delete(Long id) {
        this.tipoContribuyenteRepository.deleteById(id);
    }
}
