package pt.iade.garage4u.models;

import javax.persistence.*;

@Entity
@Table(name = "zona")
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona", nullable = false)
    private Integer id;

    @Column(name = "nome_zona", nullable = false, length = 30)
    private String nomeZona;

    @Column(name = "cod_zona", nullable = false)
    private Integer codZona;

    public Integer getCodZona() {
        return codZona;
    }

    public void setCodZona(Integer codZona) {
        this.codZona = codZona;
    }

    public String getNomeZona() {
        return nomeZona;
    }

    public void setNomeZona(String nomeZona) {
        this.nomeZona = nomeZona;
    }

    public Integer getIdZona() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
