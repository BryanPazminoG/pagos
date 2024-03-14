package com.banquito.core.pagos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.pagos.service.ExternalService.TransaccionRestService;

@Service
public class TransaccionService {

    private final TransaccionRestService transaccionRestService;

    public TransaccionService(TransaccionRestService transaccionRestService) {
        this.transaccionRestService = transaccionRestService;
    }

    public ResponseEntity<String> obtenerPorId(Integer codTransaccion) {
        return transaccionRestService.obtenerPorId(codTransaccion);
    }

    public ResponseEntity<String> crear(String informacionTransaccion) {
        return transaccionRestService.crear(informacionTransaccion);
    }

    public ResponseEntity<String> depositar(String numCuenta, String valorDebe) {
        return transaccionRestService.depositar(numCuenta, valorDebe);
    }

    public ResponseEntity<String> retirar(String numCuenta, String valorHaber) {
        return transaccionRestService.retirar(numCuenta, valorHaber);
    }

    public ResponseEntity<String> transferir(String informacionTransferencia) {
        return transaccionRestService.transferir(informacionTransferencia);
    }

    public ResponseEntity<String> buscarPorCodigoCuenta(Integer codCuenta) {
        return transaccionRestService.buscarPorCodigoCuenta(codCuenta);
    }
}
