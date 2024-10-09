package pe.sintad.prueba.controller;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import pe.sintad.prueba.service.EntidadService;

@RestController
@RequestMapping("entidades")
@AllArgsConstructor
@Tag(name = "entidades")
public class EntidadController {
    
    EntidadService entidadService;
    
    @GetMapping
    public Page<Entidad> findAll(@ParameterObject Pageable pageable) {
        return entidadService.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<Entidad> findById(@PathVariable Long id) {
        return ResponseEntity.of(entidadService.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long create(@RequestBody @Valid EntidadRequest entidadRequest) {
        return entidadService.create(entidadRequest);
    }

    @PutMapping("{id}")
    public ResponseEntity<Long> edit(@PathVariable Long id, @RequestBody @Valid EntidadRequest entidadRequest) {
        return entidadService.edit(id, entidadRequest).map(newEntity -> {
            return ResponseEntity.ok(newEntity.getId());
        }).orElse(ResponseEntity.notFound().build());
    }
}

