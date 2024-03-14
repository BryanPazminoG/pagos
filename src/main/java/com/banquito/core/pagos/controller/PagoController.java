package com.banquito.core.pagos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/cuentas")
    public ResponseEntity<String> listarCuentas() {
        return cuentaService.listarTodo();
    }

    @GetMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> obtenerCuentaPorId(@PathVariable Integer codCuenta) {
        return cuentaService.obtenerPorId(codCuenta);
    }

    @PostMapping("/cuentas")
    public ResponseEntity<String> crearCuenta(@RequestBody String informacionCuenta) {
        return cuentaService.crear(informacionCuenta);
    }

    @PutMapping("/cuentas/{codCuenta}")
    public ResponseEntity<String> actualizarCuenta(@PathVariable Integer codCuenta, @RequestBody String informacionCuenta) {
        return cuentaService.actualizar(codCuenta, informacionCuenta);
    }

    @DeleteMapping("/cuentas/{idCuenta}")
    public ResponseEntity<String> eliminarCuenta(@PathVariable Integer idCuenta) {
        return cuentaService.eliminar(idCuenta);
    }

    @GetMapping("/cuentas/numero/{numeroCuenta}")
    public ResponseEntity<String> obtenerPorNumeroCuenta(@PathVariable String numeroCuenta) {
        return cuentaService.obtenerPorNumeroCuenta(numeroCuenta);
    }

    @PutMapping("/cuentas/actualizarBalance")
    public ResponseEntity<String> actualizarBalance(@RequestParam String informacionCuenta, @RequestParam String codCuenta) {
        return cuentaService.actualizarBalance(informacionCuenta, codCuenta);
    }

    @GetMapping("/cuentas/cliente/{codCliente}")
    public ResponseEntity<String> obtenerCuentasCliente(@PathVariable String codCliente) {
        return cuentaService.obtenerCuentasCliente(codCliente);
    }

    @GetMapping("/transacciones/{codTransaccion}")
    public ResponseEntity<String> obtenerTransaccionPorId(@PathVariable Integer codTransaccion) {
        return transaccionService.obtenerPorId(codTransaccion);
    }

    @PostMapping("/transacciones")
    public ResponseEntity<String> crearTransaccion(@RequestBody String informacionTransaccion) {
        return transaccionService.crear(informacionTransaccion);
    }

    @PostMapping("/transacciones/depositar")
    public ResponseEntity<String> depositar(@RequestParam String numCuenta, @RequestParam String valorDebe) {
        return transaccionService.depositar(numCuenta, valorDebe);
    }

    @PostMapping("/transacciones/retirar")
    public ResponseEntity<String> retirar(@RequestParam String numCuenta, @RequestParam String valorHaber) {
        return transaccionService.retirar(numCuenta, valorHaber);
    }

    @PostMapping("/transacciones/transferir")
    public ResponseEntity<String> transferir(@RequestBody String informacionTransferencia) {
        return transaccionService.transferir(informacionTransferencia);
    }

    @GetMapping("/transacciones/cuenta/{codCuenta}")
    public ResponseEntity<String> buscarTransaccionesPorCodigoCuenta(@PathVariable Integer codCuenta) {
        return transaccionService.buscarPorCodigoCuenta(codCuenta);
    }
}
