package com.banquito.core.pagos.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.banquito.core.pagos.service.ExternalService.ClienteRestService;
import com.banquito.core.pagos.service.ExternalService.TransaccionRestService;

@Service
public class PagoService {

    private ClienteRestService clienteRestService; 
    private TransaccionRestService transaccionRestService;

    public PagoService(ClienteRestService clientesRestService) {
        this.clienteRestService = clientesRestService;
    }

    public PagoService(TransaccionRestService transaccionesRestService) {
        this.transaccionRestService = transaccionesRestService;
    }

    public ResponseEntity<String> listarClientes(){
        return this.clienteRestService.obtenerClientesNaturales();
    }

    public ResponseEntity<String> obtenerPorTipoIndentificacionINumero(String tipo, String numero){
        return this.clienteRestService.buscarPorIdentificacion(tipo, numero);
    }

    public ResponseEntity<String> listarTransacciones(Integer codTransaccion){
        return this.transaccionRestService.buscarPorId(codTransaccion);
    }
}