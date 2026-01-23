
package com.MResendizCajeroService.MResendizCajeroService.Service;

import com.MResendizCajeroService.MResendizCajeroService.DAO.IResbastecimientoCajero;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RebastecimientoCajeroService {
    
     @Autowired
    private IResbastecimientoCajero iResbastecimientoCajero;
    
     @Transactional
     public Result rellenar(Integer IdCajero, Integer IdDenom, Integer Cantidad){
         Result result = new Result();
         
         try {
             iResbastecimientoCajero.rellenar(IdCajero, IdDenom, Cantidad);
             
             result.correct = true;
             result.status = 202;
             result.object = "Rebastecimiendo al Cajero" + IdCajero + "fue completado";
             
         } catch (Exception ex) {
             result.correct = false;
             result.errorMessage = ex.getLocalizedMessage();
             result.ex = ex;
             result.status = 500;
         }
         
        return result;
     }
}
