package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Entity
@Table(name = "tb_tipo_documento")
@Data
@SQLDelete(sql = "UPDATE tb_tipo_documento SET estado = false WHERE id_tipo_documento=?")
@Where(clause = "estado = true")
public class TipoDocumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_documento")
    Long id;

    String codigo;

    String nombre;

    String descripcion;

    boolean estado = true;
}
