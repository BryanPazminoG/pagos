package com.banquito.core.pagos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.core.pagos.service.CuentaService;
import com.banquito.core.pagos.service.TransaccionService;

@RestController
@RequestMapping("/api/v1/cuentas")
public class PagoController {

    private final CuentaService cuentaService;
    private final TransaccionService transaccionService;


    public PagoController(CuentaService cuentaService, TransaccionService transaccionService) {
        this.cuentaService = cuentaService;
        this.transaccionService = transaccionService;
    }
}