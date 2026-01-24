
package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.CajerosJPA;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CajeroJPADAOImplementation implements ICajeroJPA{

    @Autowired
    private EntityManager entityManager; 
   
    @Override
    public Result GetAllCajeros() {
        Result result  = new Result();
        try {
            
            TypedQuery<CajerosJPA> queryCajero = entityManager.createQuery("FROM CajerosJPA", CajerosJPA.class);
            List<CajerosJPA> cajeros = queryCajero.getResultList();
            
            result.object = cajeros;
            result.correct = true;
            result.status = 200;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        return result;
    }

    @Override
    public Result GetByIdCajeros(int IdCajero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
