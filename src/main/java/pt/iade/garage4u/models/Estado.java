package pt.iade.garage4u.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {
    @Column(name = "id_estado", nullable = false)
    private Integer id_estado;

    @Id
    @Column(name = "estado", nullable = false, length = 30)
    private String estado;

    public int getEstadoId() {
        return id_estado;
    }



}
