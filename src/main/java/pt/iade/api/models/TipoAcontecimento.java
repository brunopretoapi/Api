package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "tipo_acontecimento")
public class TipoAcontecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_acontecimento", nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}