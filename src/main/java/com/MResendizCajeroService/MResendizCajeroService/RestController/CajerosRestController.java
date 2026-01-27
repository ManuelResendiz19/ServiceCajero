
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.DAO.CajeroJPADAOImplementation;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Cajeros")
public class CajerosRestController {

    @Autowired
    private CajeroJPADAOImplementation cajeroJPADAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAllCajeros(){
        Result result = new Result();
        try {
            
            result = cajeroJPADAOImplementation.GetAllCajeros();
            
            result.correct = true;
            result.status = 200;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return ResponseEntity.status(result.status).body(result);
    }
    
    @GetMapping("/{IdCajero}")
    public ResponseEntity GetByIdCajero(@PathVariable int IdCajero){
        Result result = new Result();
        try {
            
            result = cajeroJPADAOImplementation.GetByIdCajeros(IdCajero);
            
            result.correct = true;
            result.status = 200;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            result.status = 500;
        }
        return ResponseEntity.status(result.status).body(result);
    }
}
