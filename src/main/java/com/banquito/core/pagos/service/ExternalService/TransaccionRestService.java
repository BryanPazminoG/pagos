package com.banquito.core.pagos.service.ExternalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TransaccionRestService {

    private final RestTemplate restTemplate;

    public TransaccionRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<String> obtenerPorId(Integer codTransaccion) {
        String url = "http://35.232.62.178:8080/api/v1/transacciones/" + codTransaccion;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> crear(String transaccionDtoJson) {
        String url = "http://35.232.62.178:8080/api/v1/transacciones";
        ResponseEntity<String> response = restTemplate.postForEntity(url, transaccionDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> depositar(String numCuenta, String valorDebeJson) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/transacciones/depositar")
                .queryParam("numCuenta", numCuenta)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.postForEntity(url, valorDebeJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> retirar(String numCuenta, String valorHaberJson) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/transacciones/retirar")
                .queryParam("numCuenta", numCuenta)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.postForEntity(url, valorHaberJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> transferir(String transaccionDtoJson) {
        String url = "http://35.232.62.178:8080/api/v1/transacciones";
        ResponseEntity<String> response = restTemplate.postForEntity(url, transaccionDtoJson, String.class);
        validarRespuesta(response);
        return response;
    }

    public ResponseEntity<String> buscarPorCodigoCuenta(Integer codCuentaOrigen) {
        String url = UriComponentsBuilder.fromHttpUrl("http://35.232.62.178:8080/api/v1/transacciones")
                .queryParam("codCuentaOrigen", codCuentaOrigen)
                .build()
                .toString();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        validarRespuesta(response);
        return response;
    }

    private void validarRespuesta(ResponseEntity<String> response) {
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información desde el servicio externo");
        }
    }
}
