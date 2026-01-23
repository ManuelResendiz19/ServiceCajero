
package com.MResendizCajeroService.MResendizCajeroService.Service;

import com.MResendizCajeroService.MResendizCajeroService.DAO.IRetirarRepository;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


@Service
public class RetirarService {

   @Autowired
   private IRetirarRepository retirarRepository;

    @Transactional
    public Result retirar(String noCuenta, Integer idCajero, Double monto) {
        Result result = new Result();
        try {
            
            retirarRepository.retiro(noCuenta, idCajero, monto);
            
            result.correct = true;
            result.status = 200;
            result.object = "Retiro realizado exitosamente";

        } catch (DataAccessException ex) {
            String mensaje = ex.getMostSpecificCause().getMessage();

            result.correct = false;
            result.ex = ex;

            if (mensaje.contains("Saldo Insuficiente")) {
                result.status = 400;
                result.errorMessage = "Saldo insuficiente o cuenta inválida";
            } else if (mensaje.contains("billetes suficientes")) {
                result.status = 409;
                result.errorMessage = "El cajero no tiene billetes suficientes";
            } else {
                result.status = 500;
                result.errorMessage = "Error al realizar el retiro: " + mensaje;
            }

            throw new RuntimeException(result.errorMessage, ex);
        }

        return result;
    }
}

