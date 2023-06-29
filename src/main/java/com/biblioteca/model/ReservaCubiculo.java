package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_reserva_cubiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaCubiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservacubi")
    Long id;

    @Column(name="fec_reserva", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecReserva;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_estado", nullable = false)
    private Estado estado;

    @OneToOne()
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @OneToMany(mappedBy = "id_reservacubideta")
    private List<ReservaCubiculoDetalle> reservaCubiculoDetalle;
}

