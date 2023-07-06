package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "log_equipamento_del")
public class log_equipamento_del {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log_equipamento_del", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca")
    private marca idMarca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo")
    private tipo idTipo;

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

    public tipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(tipo idTipo) {
        this.idTipo = idTipo;
    }

    public marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(marca idMarca) {
        this.idMarca = idMarca;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
