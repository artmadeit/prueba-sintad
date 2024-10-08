package pe.sintad.prueba.controller;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import pe.sintad.prueba.dto.TipoDocumentoRequest;
import pe.sintad.prueba.entity.TipoDocumento;
import pe.sintad.prueba.repository.TipoDocumentoRepository;

@RestController
@RequestMapping("tipo-documentos")
@AllArgsConstructor
@Tag(name = "tipo-documentos")
public class TipoDocumentoController {
    
    TipoDocumentoRepository tipoDocumentoRepository;

    @GetMapping
    public Page<TipoDocumento> findAll(@ParameterObject Pageable pageable) {
        return tipoDocumentoRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoDocumento> findById(@PathVariable Long id) {
        return ResponseEntity.of(tipoDocumentoRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional
    public Long create(@RequestBody @Valid TipoDocumentoRequest tipoDocumentoRequest) {
        var tipoDocumento = toModel(tipoDocumentoRequest, new TipoDocumento());
        tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
        return tipoDocumento.getId();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Long> edit(@PathVariable Long id, @RequestBody @Valid TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
            toModel(tipoDocumentoRequest, tipoDocumento);
            return ResponseEntity.ok(tipoDocumentoRepository.save(tipoDocumento).getId());
        }).orElse(ResponseEntity.notFound().build());
    }

    private TipoDocumento toModel(TipoDocumentoRequest tipoDocumentoRequest, TipoDocumento tipoDocumento) {
        tipoDocumento.setCodigo(tipoDocumentoRequest.getCodigo());
        tipoDocumento.setNombre(tipoDocumentoRequest.getNombre());
        tipoDocumento.setDescripcion(tipoDocumentoRequest.getDescripcion());
        return tipoDocumento;
    }
}

