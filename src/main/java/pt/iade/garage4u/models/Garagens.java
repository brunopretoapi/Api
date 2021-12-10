package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "garagens")
public class Garagens {

    //lampada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "garagens_id", nullable = false)
    private Integer id;

    @Column(name = "localizacao", nullable = false, length = 30)
    private String localizacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_propriatario", nullable = false)
    private Utilizador idPropriatario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_zona", nullable = false)
    private Zona idZona;

    @Column(name = "lampada", nullable = false)
    private Boolean lampada = false;

    public Boolean getLampada() {
        return lampada;
    }

    public void setLampada(Boolean lampada) {
        this.lampada = lampada;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Utilizador getIdPropriatario() {
        return idPropriatario;
    }

    public void setIdPropriatario(Utilizador idPropriatario) {
        this.idPropriatario = idPropriatario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public Integer getGaragensId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
