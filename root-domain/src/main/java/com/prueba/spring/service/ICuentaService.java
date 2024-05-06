package com.prueba.spring.service;

import com.prueba.spring.postgres.entity.CuentaEntity;
import com.prueba.spring.vo.request.CuentaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;

import java.sql.Date;

public interface ICuentaService {
    GeneralResponseVo obtener();
    GeneralResponseVo crear(CuentaVo cuenta);
    GeneralResponseVo editar();
    GeneralResponseVo eliminar();

    CuentaEntity obtenerCuentaPorNumeroCuenta(String numeroCuenta);

    GeneralResponseVo generarReporteCuentaMovimiento(Date fechaInicio, Date fechaFin);
}
