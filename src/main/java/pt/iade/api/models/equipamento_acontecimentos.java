package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "equipamento_acontecimentos")
public class equipamento_acontecimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento_acontecimentos", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_acontecimentos", nullable = false)
    private acontecimentos idAcontecimentos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_tipo_acontecimento", nullable = false)
    private tipo_acontecimento idTipoAcontecimento;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_equipamentos", nullable = false)
    private equipamentos idEquipamentos;

    public equipamentos getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(equipamentos idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public tipo_acontecimento getIdTipoAcontecimento() {
        return idTipoAcontecimento;
    }

    public void setIdTipoAcontecimento(tipo_acontecimento idTipoAcontecimento) {
        this.idTipoAcontecimento = idTipoAcontecimento;
    }

    public acontecimentos getIdAcontecimentos() {
        return idAcontecimentos;
    }

    public void setIdAcontecimentos(acontecimentos idAcontecimentos) {
        this.idAcontecimentos = idAcontecimentos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
