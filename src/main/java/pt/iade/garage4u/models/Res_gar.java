package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "res_gar")
public class Res_gar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_gar_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reservas_id", nullable = false)
    private Reserva reservas;

    @ManyToOne(optional = false)
    @JoinColumn(name = "garagens_id", nullable = false)
    private Garagens garagens;

    public Garagens getGaragens() {
        return garagens;
    }

    public void setGaragens(Garagens garagens) {
        this.garagens = garagens;
    }

    public Reserva getReservas() {
        return reservas;
    }

    public void setReservas(Reserva reservas) {
        this.reservas = reservas;
    }

    public Integer getRes_garId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
