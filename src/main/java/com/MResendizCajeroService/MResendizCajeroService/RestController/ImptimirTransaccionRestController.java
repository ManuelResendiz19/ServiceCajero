
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.DTO.ImprimirRequest;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import com.MResendizCajeroService.MResendizCajeroService.Service.ImprimirTransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/imprimir")
public class ImptimirTransaccionRestController {

    @Autowired
    ImprimirTransaccionService imprimirTransaccionService;
    
    @PostMapping
    public ResponseEntity<Result> imprimir(@RequestBody ImprimirRequest request){
        Result result = new Result();
        try {
            result = imprimirTransaccionService.imprimirTransaccion(request.getIdCajero());

            result.status = 200;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
         return ResponseEntity.status(result.status).body(result);
    }
    
}
