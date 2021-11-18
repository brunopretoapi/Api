package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "res_gar")
public class Res_gar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "res_gar_id", nullable = false)
    private Integer id;

    @Column(name = "reservas_id", nullable = false)
    private Integer reservasId;

    @Column(name = "garagens_id", nullable = false)
    private Integer garagensId;

    public Integer getGaragensId() {
        return garagensId;
    }

    public void setGaragensId(Integer garagensId) {
        this.garagensId = garagensId;
    }

    public Integer getReservasId() {
        return reservasId;
    }

    public void setReservasId(Integer reservasId) {
        this.reservasId = reservasId;
    }

    public Integer getRes_garId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
