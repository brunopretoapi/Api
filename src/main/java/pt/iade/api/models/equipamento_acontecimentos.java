package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "equipamento_acontecimentos")
public class equipamento_acontecimentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamento_acontecimentos", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_acontecimentos", nullable = false)
    private acontecimentos idAcontecimentos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_acontecimento", nullable = false)
    private TipoAcontecimento idTipoAcontecimento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_equipamentos", nullable = false)
    private Equipamentos idEquipamentos;

    public Equipamentos getIdEquipamentos() {
        return idEquipamentos;
    }

    public void setIdEquipamentos(Equipamentos idEquipamentos) {
        this.idEquipamentos = idEquipamentos;
    }

    public TipoAcontecimento getIdTipoAcontecimento() {
        return idTipoAcontecimento;
    }

    public void setIdTipoAcontecimento(TipoAcontecimento idTipoAcontecimento) {
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
