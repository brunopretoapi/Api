package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "caracteristica")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caracteristica_id", nullable = false)
    private Integer id;

    @Column(name = "tipo_caracteristica", nullable = false, length = 30)
    private String tipoCaracteristica;

    public String getTipoCaracteristica() {
        return tipoCaracteristica;
    }

    public void setTipoCaracteristica(String tipoCaracteristica) {
        this.tipoCaracteristica = tipoCaracteristica;
    }

    public Integer getIdCaracteristica() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
