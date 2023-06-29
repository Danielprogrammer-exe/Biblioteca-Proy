package com.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_reserva_libro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservalibro")
    private Long id;

    @OneToOne()
    @JoinColumn(name = "id_usuario")
    private User usuario;

    @Column(name="fec_reserva", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecReserva;

    @Column(name="fec_devolucion", nullable = false)
    @Temporal(value=TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecDevolucion;

    @Column(nullable = false, length = 200)
    private String observaciones;

    @OneToMany(mappedBy = "id_reservalibrodeta")
    private List<ReservaLibroDetalle> reservaLibroDetalle;
}
