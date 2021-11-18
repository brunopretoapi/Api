package pt.iade.garage4u.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilizador")
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilizador_id", nullable = false)
    private int utilizadorId;

    @Column(name = "utilizador_name", nullable = false, length = 60)
    private String utilizadorName;

    @Column(name = "utilizador_morada", length = 30)
    private String utilizadorMorada;

    @Column(name = "utilizador_gender", nullable = false, length = 1)
    private String utilizadorGender;

    @Column(name = "utilizador_bdate", nullable = false)
    private LocalDate utilizadorBdate;

    @Column(name = "utilizador_identificacao_id")
    private Integer utilizadorIdentificacaoId;

    @Column(name = "utilizador_email", length = 30)
    private String utilizadorEmail;

    @Column(name = "utilizador_pass", length = 30)
    private String utilizadorPass;

    public String getUtilizadorPass() {
        return utilizadorPass;
    }

    public void setUtilizadorPass(String utilizadorPass) {
        this.utilizadorPass = utilizadorPass;
    }

    public String getUtilizadorEmail() {
        return utilizadorEmail;
    }

    public void setUtilizadorEmail(String utilizadorEmail) {
        this.utilizadorEmail = utilizadorEmail;
    }

    public Integer getUtilizadorIdentificacaoId() {
        return utilizadorIdentificacaoId;
    }

    public void setUtilizadorIdentificacaoId(Integer utilizadorIdentificacaoId) {
        this.utilizadorIdentificacaoId = utilizadorIdentificacaoId;
    }

    public LocalDate getUtilizadorBdate() {
        return utilizadorBdate;
    }

    public void setUtilizadorBdate(LocalDate utilizadorBdate) {
        this.utilizadorBdate = utilizadorBdate;
    }

    public String getUtilizadorGender() {
        return utilizadorGender;
    }

    public void setUtilizadorGender(String utilizadorGender) {
        this.utilizadorGender = utilizadorGender;
    }

    public String getUtilizadorMorada() {
        return utilizadorMorada;
    }

    public void setUtilizadorMorada(String utilizadorMorada) {
        this.utilizadorMorada = utilizadorMorada;
    }

    public String getUtilizadorName() {
        return utilizadorName;
    }

    public void setUtilizadorName(String utilizadorName) {
        this.utilizadorName = utilizadorName;
    }

    public Integer getUtilizadorId() {
        return utilizadorId;
    }

    public void setId(Integer id) {
        this.utilizadorId = id;
    }
}
