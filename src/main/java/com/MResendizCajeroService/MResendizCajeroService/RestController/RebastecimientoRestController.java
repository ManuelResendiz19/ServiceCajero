
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.DTO.RellenarRequest;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import com.MResendizCajeroService.MResendizCajeroService.Service.RebastecimientoCajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rellenar")
public class RebastecimientoRestController {
    
   @Autowired
   public RebastecimientoCajeroService rebastecimientoCajeroService;
    
    @PostMapping
    public ResponseEntity<Result> rellenar(@RequestBody RellenarRequest rellenar){
        Result result = new Result();
        try {
            
            rebastecimientoCajeroService.rellenar(rellenar.getIdCajero(),rellenar.getIdDenom(), rellenar.getCantidad());
            result.correct = true;
            result.status = 200;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return ResponseEntity.status(result.status).body(result);
    }
}
