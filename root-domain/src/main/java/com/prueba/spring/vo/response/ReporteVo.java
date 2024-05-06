package com.prueba.spring.vo.response;

import com.prueba.spring.postgres.entity.ClienteEntity;
import com.prueba.spring.postgres.entity.MovimientoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteVo {
    private Integer cuentaId;
    private String numeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
    private Integer clienteId;
    private ClienteEntity cliente;
    private List<MovimientoEntity> movimientos;
}
