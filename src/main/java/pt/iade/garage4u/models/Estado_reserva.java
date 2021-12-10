package pt.iade.garage4u.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "estado_reserva")
public class Estado_reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_reserva_id", nullable = false)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva idReserva;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado idEstado;

    @Column(name = "hora_de_entrda", nullable = false)
    private Instant horaDeEntrda;

    @Column(name = "hora_saida")
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

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getEstadoReservaId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
