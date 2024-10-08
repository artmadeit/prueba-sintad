package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_entidad")
@Data
public class Entidad {
    @Id
    @Column(name = "id_entidad")
    Long id;

    @ManyToOne
    TipoDocumento tipoDocumento;

    String nroDocumento;

    String razonSocial;

    String nombreComercial;

    @ManyToOne
    TipoContribuyente tipoContribuyente;

    String direccion;

    String telefono;

    boolean estado;
}
