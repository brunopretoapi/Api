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

    @Column(name = "id_reserva", nullable = false)
    private Integer idReserva;

    @Column(name = "id_estado")
    private Integer idEstado;

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

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Integer getEstadoReservaId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
