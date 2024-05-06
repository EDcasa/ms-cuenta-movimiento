package com.prueba.spring.service;

import com.prueba.spring.vo.request.MovimientoVo;
import com.prueba.spring.vo.response.GeneralResponseVo;

/**
 *
 *
 * @autor ecasa on 2024/05/02.
 * @version 1.0.0
 */

public interface IMovimientoService {

    GeneralResponseVo obtener();

    GeneralResponseVo crear(MovimientoVo movimiento);

    GeneralResponseVo editar();

    GeneralResponseVo eliminar();
}
