package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "tb_entidad")
@Data
@SQLDelete(sql = "UPDATE tb_entidad SET estado = false WHERE id_entidad=?")
@Where(clause = "estado = true")
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

    boolean estado = true;
}
