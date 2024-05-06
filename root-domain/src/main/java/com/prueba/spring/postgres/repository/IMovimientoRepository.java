package com.prueba.spring.postgres.repository;

import com.prueba.spring.postgres.entity.MovimientoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface IMovimientoRepository extends CrudRepository<MovimientoEntity, Integer> {

    List<MovimientoEntity> findAllByCuenta_CuentaIdAndFechaAfterAndFechaBefore(Integer cuentaId, Date fechaInicio, Date fechaFin);
}
