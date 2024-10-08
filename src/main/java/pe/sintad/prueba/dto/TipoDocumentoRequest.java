package pe.sintad.prueba.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TipoDocumentoRequest {
    
    @NotBlank
    String codigo;

    @NotBlank
    String nombre;

    String descripcion;
}
