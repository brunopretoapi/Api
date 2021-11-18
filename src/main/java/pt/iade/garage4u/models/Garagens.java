package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "garagens")
public class Garagens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "garagens_id", nullable = false)
    private Integer id;

    @Column(name = "localizacao", length = 30)
    private String localizacao;

    @Column(name = "id_propriatario")
    private Integer idPropriatario;

    @Column(name = "id_estado")
    private Integer idEstado;

    @Column(name = "id_zona")
    private Integer idZona;

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdPropriatario() {
        return idPropriatario;
    }

    public void setIdPropriatario(Integer idPropriatario) {
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
