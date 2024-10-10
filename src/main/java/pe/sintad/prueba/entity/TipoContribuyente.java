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
@Table(name = "tb_tipo_contribuyente")
@Data
@SQLDelete(sql = "UPDATE tb_tipo_contribuyente SET estado = false WHERE id_tipo_contribuyente=?")
@Where(clause = "estado = true")
public class TipoContribuyente {
    @Id    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    Long id;

    String nombre;

    boolean estado = true;
}
