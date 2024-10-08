package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_tipo_documento")
@Data
public class TipoDocumento {
    @Id
    @Column(name = "id_tipo_documento")
    Long id;

    String codigo;

    String nombre;

    String descripcion;

    boolean estado;
}
