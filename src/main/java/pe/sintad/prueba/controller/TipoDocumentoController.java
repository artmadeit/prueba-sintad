package pe.sintad.prueba.controller;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import pe.sintad.prueba.dto.TipoDocumentoRequest;
import pe.sintad.prueba.entity.TipoDocumento;
import pe.sintad.prueba.service.TipoDocumentoService;

@RestController
@RequestMapping("tipo-documentos")
@AllArgsConstructor
@Tag(name = "tipo-documentos")
public class TipoDocumentoController {
    TipoDocumentoService tipoDocumentoService;
    
    @GetMapping
    public Page<TipoDocumento> findAll(@ParameterObject Pageable pageable) {
        return tipoDocumentoService.findAll(pageable);
    }

    @GetMapping("{id}")
    public ResponseEntity<TipoDocumento> findById(@PathVariable Long id) {
        return ResponseEntity.of(tipoDocumentoService.findById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long create(@RequestBody @Valid TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoService.create(tipoDocumentoRequest);
    }

    @PutMapping("{id}")
    public ResponseEntity<Long> edit(@PathVariable Long id, @RequestBody @Valid TipoDocumentoRequest tipoDocumentoRequest) {
        return tipoDocumentoService.edit(id, tipoDocumentoRequest).map(tipoDocumento -> {
            return ResponseEntity.ok(tipoDocumento.getId());
        }).orElse(ResponseEntity.notFound().build());
    }

    
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        tipoDocumentoService.delete(id);
    }
}
