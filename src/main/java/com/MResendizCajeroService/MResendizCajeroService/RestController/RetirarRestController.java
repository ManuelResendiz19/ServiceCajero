
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.DTO.RetiroRequest;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import com.MResendizCajeroService.MResendizCajeroService.Service.RetirarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/retirar")
public class RetirarRestController {
    
    @Autowired
    RetirarService retirarService;
   

    @PostMapping
    public ResponseEntity<Result> retirar(@RequestBody RetiroRequest request) {
        Result result = new Result();
        try {
            retirarService.retirar(request.getNoTarjeta(), request.getIdCajero(), request.getMonto());

            result.correct = true;
            result.status = 200;
            result.object = "Retiro realizado exitosamente";
            return ResponseEntity.ok(result);

        } catch (IllegalArgumentException ex) {
            result.correct = false;
            result.status = 400;
            result.errorMessage = ex.getMessage();
            result.ex = ex;
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);

        } catch (IllegalStateException ex) {
            result.correct = false;
            result.status = 409;
            result.errorMessage = ex.getMessage();
            result.ex = ex;
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);

        } catch (Exception ex) {
            result.correct = false;
            result.status = 500;
            result.errorMessage = "Error al procesar el retiro";
            result.ex = ex;
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
        }
    }
}
