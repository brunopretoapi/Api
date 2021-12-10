package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "esqueceu_pass")
public class Esqueceu_pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "esq_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "utilizador_id", nullable = false)
    private Utilizador utilizador;

    @Column(name = "rkay", nullable = false, length = 30)
    private String rkay;

    public String getRkay() {
        return rkay;
    }

    public void setRkay(String rkay) {
        this.rkay = rkay;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Integer getIdEsqueceu() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
