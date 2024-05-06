package com.prueba.spring.vo.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 *
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoVo {
    private Integer movimientoId;
    private Date fecha;
    private String tipo;
    private Double valor;
    private Double saldo;
    private String numeroCuenta;
}
