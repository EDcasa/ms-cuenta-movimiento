package com.prueba.spring.controller;


import com.prueba.spring.api.service.CuentaService;
import com.prueba.spring.vo.request.CuentaVo;
import com.prueba.spring.vo.response.GeneralResponseVo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 * @author ecasa on 2024/05/02.
 * @version 1.0.0
 */
@RestController
@RequestMapping("/cuentas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "Bearer")
public class CuentaController {

    private final transient CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    //CRUD
    @GetMapping(value = "/obtenerCuentas", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> obtener(){
        return null;
    }

    @PostMapping(value = "/crearCuenta", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> crear(@RequestBody CuentaVo cuenta){
        GeneralResponseVo response = cuentaService.crear(cuenta);
        return new ResponseEntity<>(response, response.getStatus().equals("SUCCESS") ? HttpStatus.OK : HttpStatus.BAD_REQUEST );
    }

    @PutMapping(value = "/editarCuenta", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> editar(@RequestBody String movimiento){
        return null;
    }

    @DeleteMapping(value = "/eliminarCuenta", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> eliminar(@RequestBody String movimiento){
        return null;
    }
}
