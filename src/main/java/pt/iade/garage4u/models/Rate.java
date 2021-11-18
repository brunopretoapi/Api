package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rate_id", nullable = false)
    private Integer id;

    @Column(name = "id_garagem", nullable = false)
    private Integer idGaragem;

    @Column(name = "id_utilizador", nullable = false)
    private Integer idUtilizador;

    @Column(name = "rate")
    private Integer rate;

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Integer idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Integer idGaragem) {
        this.idGaragem = idGaragem;
    }

    public Integer getRateId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
