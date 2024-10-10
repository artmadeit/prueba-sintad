package pe.sintad.prueba.controller;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import pe.sintad.prueba.dto.TipoContribuyenteRequest;
import pe.sintad.prueba.entity.TipoContribuyente;
import pe.sintad.prueba.service.TipoContribuyenteService;

@RestController
@RequestMapping("tipo-contribuyentes")
@AllArgsConstructor
@Tag(name = "tipo-contribuyentes")
public class TipoContribuyenteController {

    TipoContribuyenteService tipoContribuyenteService;

    @GetMapping
    public Page<TipoContribuyente> findAll(@ParameterObject Pageable pageable) {
        return tipoContribuyenteService.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoContribuyente> findById(@PathVariable Long id) {
        return ResponseEntity.of(tipoContribuyenteService.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long create(@RequestBody @Valid TipoContribuyenteRequest tipoContribuyenteRequest) {
        return tipoContribuyenteService.create(tipoContribuyenteRequest);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<Long> edit(
            @PathVariable Long id,
            @RequestBody @Valid TipoContribuyenteRequest tipoContribuyenteRequest) {
        return tipoContribuyenteService.edit(id, tipoContribuyenteRequest).map(tipoContribuyente -> {
            return ResponseEntity.ok(tipoContribuyente.getId());
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public void edit(@PathVariable Long id) {
        tipoContribuyenteService.delete(id);
    }
}
