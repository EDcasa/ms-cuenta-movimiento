package com.prueba.spring.postgres.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Entity Cuenta
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@Entity
@Data
@Table(name = "cuenta", schema = "public")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuentaid", nullable = false)
    private Integer cuentaId;

    @Column(name = "numero_cuenta", nullable = false, length = 50)
    private String numeroCuenta;

    @Column(name = "tipo_cuenta", nullable = false, length = 50)
    private String tipoCuenta;

    @Column(name = "saldo_inicial", nullable = false, length = 50)
    private Double saldoInicial;

    @Column(name = "estado", nullable = false, length = 50)
    private Boolean estado;

    @OneToOne
    @JoinColumn(name = "clienteid")
    private ClienteEntity cliente;
}
