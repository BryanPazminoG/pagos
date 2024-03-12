package com.banquito.core.pagos.service.ExternalService;

import java.math.BigDecimal;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class TransaccionRestService {

    private final RestTemplate restTemplate;

    public TransaccionRestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{codTransaccion}")
    public ResponseEntity<String> buscarPorId(Integer codTransaccion) {
        String url = "http://localhost:8081/api/v1/transacciones";
        
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error al obtener la información del producto desde el servicio externo");
        }
        return response;
    }

    public ResponseEntity<String> depositar(String numCuenta, BigDecimal valorDebe) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/transacciones/depositos")
                .path("/depositar")
                .queryParam("numCuenta", numCuenta)
                .queryParam("valorDebe", valorDebe)
                .build()
                .toUriString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<String> retirar(String numCuenta, BigDecimal valorHaber) {
        String url = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/api/v1/transacciones/retiros")
                .path("/retirar")
                .queryParam("numCuenta", numCuenta)
                .queryParam("valorHaber", valorHaber)
                .build()
                .toUriString();
        restTemplate.put(url, null);
        return ResponseEntity.noContent().build();
    }
}
