package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_entidad")
@Data
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento")
    TipoDocumento tipoDocumento;

    String nroDocumento;

    String razonSocial;

    String nombreComercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente")
    TipoContribuyente tipoContribuyente;

    String direccion;

    String telefono;

    boolean estado;
}
