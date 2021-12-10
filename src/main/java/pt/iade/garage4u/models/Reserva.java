package pt.iade.garage4u.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservas_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_utilizador", nullable = false)
    private Utilizador idUtilizador;

    @Column(name = "hora_de_entrda", nullable = false)
    private Instant horaDeEntrda;

    @Column(name = "hora_saida", nullable = false)
    private Instant horaSaida;

    public Instant getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Instant horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Instant getHoraDeEntrda() {
        return horaDeEntrda;
    }

    public void setHoraDeEntrda(Instant horaDeEntrda) {
        this.horaDeEntrda = horaDeEntrda;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Integer getReservaID() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
