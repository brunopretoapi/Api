package pt.iade.api.models;

import javax.persistence.*;

@Entity
@Table(name = "necessidade")
public class necessidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_necessidade", nullable = false)
    private Integer id;

    @Column(name = "necessidade", nullable = false, length = 25)
    private String necessidade;

    public String getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
