package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "caracteristicas")
public class Caracteristicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caracteristicas_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "caracteristica_id", nullable = false)
    private Caracteristica caracteristica;

    @ManyToOne(optional = false)
    @JoinColumn(name = "garagens_id", nullable = false)
    private Garagens garagens;

    public Garagens getGaragens() {
        return garagens;
    }

    public void setGaragens(Garagens garagens) {
        this.garagens = garagens;
    }

    public Caracteristica getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Integer getCaracteristicasId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
