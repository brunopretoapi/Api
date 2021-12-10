package pt.iade.garage4u.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "utilizador")
public class Utilizador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "utilizador_id", nullable = false)
    private Integer utilizadorId;

    @Column(name = "utilizador_name", nullable = false, length = 60)
    private String utilizadorName;

    @Column(name = "utilizador_morada", length = 30)
    private String utilizadorMorada;

    @Column(name = "utilizador_gender", nullable = false, length = 1)
    private String utilizadorGender;

    @Column(name = "utilizador_bdate", nullable = false)
    private LocalDate utilizadorBdate;

    @Column(name = "utilizador_identificacao_id", nullable = false)
    private Integer utilizadorIdentificacaoId;

    @Column(name = "utilizador_email", nullable = false, length = 30)
    private String utilizadorEmail;

    @Column(name = "utilizador_pass", nullable = false, length = 30)
    private String utilizadorPass;

    @Column(name = "quantidade_dinheiro", nullable = false)
    private BigDecimal quantidadeDinheiro;

    @Column(name = "num_cartao", nullable = false)
    private Integer numCartao;

    @Column(name = "cvv", nullable = false)
    private Integer cvv;

    @Column(name = "nome_cartao", nullable = false, length = 30)
    private String nomeCartao;

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Integer getNumCartao() {
        return numCartao;
    }

    public void setNumCartao(Integer numCartao) {
        this.numCartao = numCartao;
    }

    public BigDecimal getQuantidadeDinheiro() {
        return quantidadeDinheiro;
    }

    public void setQuantidadeDinheiro(BigDecimal quantidadeDinheiro) {
        this.quantidadeDinheiro = quantidadeDinheiro;
    }

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

    public Integer getUtilizadorID() {
        return utilizadorId;
    }

    public void setId(Integer id) {
        this.utilizadorId = id;
    }
}



