package com.prueba.spring.api.service;

import com.prueba.spring.postgres.entity.ClienteEntity;
import com.prueba.spring.postgres.entity.CuentaEntity;
import com.prueba.spring.postgres.entity.MovimientoEntity;
import com.prueba.spring.postgres.repository.ICuentaRepository;
import com.prueba.spring.postgres.repository.IMovimientoRepository;
import com.prueba.spring.service.ICuentaService;
import com.prueba.spring.vo.request.CuentaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import com.prueba.spring.vo.response.ReporteVo;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CuentaService implements ICuentaService {

    private final transient ICuentaRepository cuentaRepository;
    private final transient IMovimientoRepository movimientoRepository;

    public CuentaService(ICuentaRepository cuentaRepository, IMovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public GeneralResponseVo obtener() {
        return null;
    }

    @Override
    public GeneralResponseVo crear(CuentaVo cuenta) {
        try{
            CuentaEntity cuentaEntity = new CuentaEntity();
            ClienteEntity cliente = new ClienteEntity();
            cuentaEntity.setNumeroCuenta(cuenta.getNumeroCuenta());
            cuentaEntity.setTipoCuenta(cuenta.getTipoCuenta());
            cuentaEntity.setSaldoInicial(cuenta.getSaldoInicial());
            cuentaEntity.setEstado(cuenta.getEstado());
            cuentaEntity.setCliente(cliente);
            cuentaRepository.save(cuentaEntity);
            return new GeneralResponseVo("Cuenta creada correctamente", cuentaEntity, "SUCCESS");
        } catch (Exception e) {
            return new GeneralResponseVo("Error al crear la cuenta", null, "ERROR");
        }
    }

    @Override
    public GeneralResponseVo editar() {
        return null;
    }

    @Override
    public GeneralResponseVo eliminar() {
        return null;
    }

    @Override
    public CuentaEntity obtenerCuentaPorNumeroCuenta(String numeroCuenta) {
        return cuentaRepository.findByNumeroCuenta(numeroCuenta);
    }

    @Override
    public GeneralResponseVo generarReporteCuentaMovimiento(Date fechaInicio, Date fechaFin) {
        try {
            List<CuentaEntity> cuentas = cuentaRepository.findWithClient();
            List<ReporteVo> reporte = new ArrayList<>();
            for (CuentaEntity cuenta : cuentas) {
                ReporteVo reporteVo = new ReporteVo();
                reporteVo.setCliente(cuenta.getCliente());
                reporteVo.setNumeroCuenta(cuenta.getNumeroCuenta());
                reporteVo.setTipoCuenta(cuenta.getTipoCuenta());
                reporteVo.setSaldoInicial(cuenta.getSaldoInicial());
                reporteVo.setEstado(cuenta.getEstado());
                List<MovimientoEntity> mov = movimientoRepository.findAllByCuenta_CuentaIdAndFechaAfterAndFechaBefore(cuenta.getCuentaId(), fechaInicio, fechaFin);
                reporteVo.setMovimientos(mov);
                reporte.add(reporteVo);
            }
            return new GeneralResponseVo("Reporte generado correctamente", reporte, "SUCCESS");
        } catch (Exception e) {
            return new GeneralResponseVo(e.getMessage(), null, "ERROR");
        }
    }
}
