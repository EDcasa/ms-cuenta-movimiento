package com.prueba.spring.postgres.repository;


import com.prueba.spring.postgres.entity.CuentaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICuentaRepository extends CrudRepository<CuentaEntity, Integer> {

    CuentaEntity findByNumeroCuenta(String numeroCuenta);

    List<CuentaEntity> findAll();
    @Query("SELECT e FROM CuentaEntity e JOIN e.cliente")
    List<CuentaEntity> findWithClient();

}
