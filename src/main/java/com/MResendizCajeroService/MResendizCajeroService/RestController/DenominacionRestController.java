
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.DAO.DenominacionJPADAOImplementation;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/denominaciomes")
public class DenominacionRestController {
    
    @Autowired
    DenominacionJPADAOImplementation denominacionJPADAOImplementation;
    
    @GetMapping
    public ResponseEntity GetAllCajeros(){
        Result result = new Result();
        try {
            
            result = denominacionJPADAOImplementation.GetAll();
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
