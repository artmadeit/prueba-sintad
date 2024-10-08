package pe.sintad.prueba.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EntidadRequest {
    
    @NotNull
    Long tipoDocumentoId;

    @NotBlank
    String nroDocumento;
    
    @NotBlank
    String razonSocial;

    @NotBlank
    String nombreComercial;

    @NotNull
    Long tipoContribuyenteId;

    String direccion;

    String telefono;
}
