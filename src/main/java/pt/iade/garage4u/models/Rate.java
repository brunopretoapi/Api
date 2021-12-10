package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_res_gar", nullable = false)
    private Res_gar idResGar;

    @Column(name = "rate")
    private Integer rate;

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Res_gar getIdResGar() {
        return idResGar;
    }

    public void setIdResGar(Res_gar idResGar) {
        this.idResGar = idResGar;
    }

    public Integer getRateId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
