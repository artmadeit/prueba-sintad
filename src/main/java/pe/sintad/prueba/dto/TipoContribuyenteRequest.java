package pe.sintad.prueba.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TipoContribuyenteRequest {
    @NotBlank
    String nombre;
}
