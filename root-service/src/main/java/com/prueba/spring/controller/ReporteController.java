package com.prueba.spring.controller;


import com.prueba.spring.service.ICuentaService;
import com.prueba.spring.service.IMovimientoService;
import com.prueba.spring.vo.response.GeneralResponseVo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "Bearer")
public class ReporteController {

    private final transient ICuentaService cuentaService;

    public ReporteController(ICuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping(value = "", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> obtener(
            @RequestParam(value = "fechaInicio") Date fechaInicio,
            @RequestParam(value = "fechaFin") Date fechaFin
            ){
        GeneralResponseVo response = cuentaService.generarReporteCuentaMovimiento(fechaInicio, fechaFin);
        return new ResponseEntity<>(response, response.getStatus().equals("SUCCESS") ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }
}
