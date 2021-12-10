package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "dispositivo")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disp_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_garagem", nullable = false)
    private Garagens idGaragem;

    @Column(name = "rkay", nullable = false, length = 30)
    private String rkay;

    @Column(name = "estado_portao", nullable = false)
    private Boolean estadoPortao = false;

    @Column(name = "estado_luz", nullable = false)
    private Boolean estadoLuz = false;

    public Boolean getEstadoLuz() {
        return estadoLuz;
    }

    public void setEstadoLuz(Boolean estadoLuz) {
        this.estadoLuz = estadoLuz;
    }

    public Boolean getEstadoPortao() {
        return estadoPortao;
    }

    public void setEstadoPortao(Boolean estadoPortao) {
        this.estadoPortao = estadoPortao;
    }

    public String getRkay() {
        return rkay;
    }

    public void setRkay(String rkay) {
        this.rkay = rkay;
    }

    public Garagens getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Garagens idGaragem) {
        this.idGaragem = idGaragem;
    }

    public Integer getIdDispositivo() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
