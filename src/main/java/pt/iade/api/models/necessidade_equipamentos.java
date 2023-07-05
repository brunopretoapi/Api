package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "necessidade_equipamentos")
public class necessidade_equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_necessidade_equipamentos", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_necessidade", nullable = false)
    private necessidade idNecessidade;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipamentos", nullable = false)
    private Equipamentos idEquipamentos;

    public Equipamentos getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(Equipamentos idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public necessidade getIdNecessidade() {
        return idNecessidade;
    }

    public void setIdNecessidade(necessidade idNecessidade) {
        this.idNecessidade = idNecessidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
