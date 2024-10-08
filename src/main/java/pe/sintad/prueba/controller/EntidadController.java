package pe.sintad.prueba.controller;

import javax.validation.Valid;

import org.springdoc.core.annotations.ParameterObject;
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
import pe.sintad.prueba.dto.EntidadRequest;
import pe.sintad.prueba.entity.Entidad;
import pe.sintad.prueba.repository.EntidadRepository;
import pe.sintad.prueba.repository.TipoContribuyenteRepository;
import pe.sintad.prueba.repository.TipoDocumentoRepository;

@RestController
@RequestMapping("entidades")
@AllArgsConstructor
@Tag(name = "entidades")
public class EntidadController {

    TipoDocumentoRepository tipoDocumentoRepository;
    TipoContribuyenteRepository tipoContribuyenteRepository;
    EntidadRepository entidadRepository;

    @GetMapping
    public Page<Entidad> findAll(@ParameterObject Pageable pageable) {
        return entidadRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Entidad> findById(@PathVariable Long id) {
        return ResponseEntity.of(entidadRepository.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Transactional
    public Long create(@RequestBody @Valid EntidadRequest entidadRequest) {
        var entidad = toModel(entidadRequest, new Entidad());
        entidad = entidadRepository.save(entidad);
        return entidad.getId();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Long> edit(@PathVariable Long id, @RequestBody @Valid EntidadRequest entidadRequest) {
        return entidadRepository.findById(id).map(entidad -> {
            toModel(entidadRequest, entidad);
            return ResponseEntity.ok(entidadRepository.save(entidad).getId());
        }).orElse(ResponseEntity.notFound().build());
    }

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
}

