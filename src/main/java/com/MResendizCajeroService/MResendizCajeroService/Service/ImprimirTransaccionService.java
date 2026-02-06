
package com.MResendizCajeroService.MResendizCajeroService.Service;

import com.MResendizCajeroService.MResendizCajeroService.DAO.IimprimirTransaccionRepository;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImprimirTransaccionService {

    @Autowired
    IimprimirTransaccionRepository iimprimirTransaccionRepository;
    
    @Transactional
    public Result imprimirTransaccion(Integer IdCajero){
        Result result = new Result();
        try {
            String baucher = iimprimirTransaccionRepository.imprimir(IdCajero);
            
            result.correct = true;
            result.object = baucher.split("\n");
            result.status = 200;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }
    
}