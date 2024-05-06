package com.prueba.spring.api.service;

import com.prueba.spring.postgres.entity.CuentaEntity;
import com.prueba.spring.postgres.entity.MovimientoEntity;
import com.prueba.spring.postgres.repository.ICuentaRepository;
import com.prueba.spring.postgres.repository.IMovimientoRepository;
import com.prueba.spring.service.IMovimientoService;
import com.prueba.spring.vo.request.MovimientoVo;
import com.prueba.spring.vo.response.GeneralResponseVo;

public class MovimientoService implements IMovimientoService {

    private final transient IMovimientoRepository movimientoRepository;
    private final transient ICuentaRepository cuentaRepository;

    public MovimientoService(IMovimientoRepository movimientoRepository, ICuentaRepository cuentaRepository) {
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @Override
    public GeneralResponseVo obtener() {
        return null;
    }

    @Override
    public GeneralResponseVo crear(MovimientoVo movimiento) {
        try {
            MovimientoEntity movimientoEntity = new MovimientoEntity();
            CuentaEntity cuentaEntity = cuentaRepository.findByNumeroCuenta(movimiento.getNumeroCuenta());
            if(cuentaEntity.getSaldoInicial()<movimiento.getValor()){
                return new GeneralResponseVo("Saldo insuficiente", null, "ERROR");
            }
            movimientoEntity.setFecha(movimiento.getFecha());
            movimientoEntity.setTipoMovimiento(movimiento.getTipo());
            movimientoEntity.setValor(movimiento.getValor());
            movimientoEntity.setSaldo(cuentaEntity.getSaldoInicial()-movimiento.getValor());
            movimientoEntity.setCuenta(cuentaEntity);
            movimientoRepository.save(movimientoEntity);
            cuentaEntity.setSaldoInicial(cuentaEntity.getSaldoInicial()-movimiento.getValor());
            cuentaRepository.save(cuentaEntity);
            return new GeneralResponseVo("Movimiento creado correctamente", movimientoEntity, "SUCCESS");
        } catch (Exception e) {
         return new GeneralResponseVo(e.getMessage(), movimiento, "ERROR");
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
}
