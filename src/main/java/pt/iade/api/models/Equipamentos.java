package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "equipamentos")
public class Equipamentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipamentos", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca idMarca;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo idTipo;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "descricao", length = 1000)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tipo idTipo) {
        this.idTipo = idTipo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
