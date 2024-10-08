package pe.sintad.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_tipo_contribuyente")
@Data
public class TipoContribuyente {
    @Id
    @Column(name = "id_tipo_contribuyente")
    Long id;

    String nombre;

    boolean estado;
}
