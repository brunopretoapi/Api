package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tipo_acontecimento")
public class tipo_acontecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_acontecimento", nullable = false)
    private Integer id;

    @Column(name = "tipo_acontecimento", length = 25)
    private String tipoAcontecimento;

    public String getTipoAcontecimento() {
        return tipoAcontecimento;
    }

    public void setTipoAcontecimento(String tipoAcontecimento) {
        this.tipoAcontecimento = tipoAcontecimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
