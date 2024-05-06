package com.prueba.spring.controller;


import com.prueba.spring.vo.request.MovimientoVo;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("/movimientos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SecurityRequirement(name = "Bearer")
public class MovimientoController {

    //CRUD
    @GetMapping(value = "/obtenerMovimientos", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> obtener(){
        return null;
    }

    @PostMapping(value = "/crearMovimiento", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> crear(@RequestBody MovimientoVo movimiento){

        return null;
    }

    @PutMapping(value = "/editarMovimiento", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> editar(@RequestBody String movimiento){
        return null;
    }

    @DeleteMapping(value = "/eliminarMovimiento", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> eliminar(@RequestBody String movimiento){
        return null;
    }

}
