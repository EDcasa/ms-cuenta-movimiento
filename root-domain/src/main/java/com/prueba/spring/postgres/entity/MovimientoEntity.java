package com.prueba.spring.postgres.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Entity Movimiento
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@Entity
@Data
@Table(name = "movimiento", schema = "public")
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movimientoid", nullable = false)
    private Integer movimientoId;

    @Column(name = "fecha", nullable = false, length = 50)
    private Date fecha;

    @Column(name = "tipo_movimiento", nullable = false, length = 50)
    private String tipoMovimiento;

    @Column(name = "valor", nullable = false, length = 50)
    private Double valor;

    @Column(name = "saldo", nullable = false, length = 50)
    private Double saldo;

    @ManyToOne
    @JoinColumn(name = "cuentaid")
    private CuentaEntity cuenta;

}
