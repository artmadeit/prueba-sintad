package pe.sintad.prueba.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import pe.sintad.prueba.dto.TipoDocumentoRequest;
import pe.sintad.prueba.entity.TipoDocumento;
import pe.sintad.prueba.repository.TipoDocumentoRepository;
import pe.sintad.prueba.service.TipoDocumentoService;

@Service
@AllArgsConstructor
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public Page<TipoDocumento> findAll(Pageable pageable) {
        return tipoDocumentoRepository.findAll(pageable);
    }

    @Override
    public Optional<TipoDocumento> findById(Long id) {
        return tipoDocumentoRepository.findById(id);
    }

    @Override
    @Transactional
    public Long create(TipoDocumentoRequest tipoDocumentoRequest) {
        var tipoDocumento = toModel(tipoDocumentoRequest, new TipoDocumento());
        tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
        return tipoDocumento.getId();
    }

    @Override
    @Transactional
    public Optional<TipoDocumento> edit(Long id, TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
            toModel(tipoDocumentoRequest, tipoDocumento);
            return tipoDocumentoRepository.save(tipoDocumento);
        });
    }

    private TipoDocumento toModel(TipoDocumentoRequest tipoDocumentoRequest, TipoDocumento tipoDocumento) {
        tipoDocumento.setCodigo(tipoDocumentoRequest.getCodigo());
        tipoDocumento.setNombre(tipoDocumentoRequest.getNombre());
        tipoDocumento.setDescripcion(tipoDocumentoRequest.getDescripcion());
        return tipoDocumento;
    }

    @Override
    public void delete(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}
