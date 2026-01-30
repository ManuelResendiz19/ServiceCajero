
package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import com.MResendizCajeroService.MResendizCajeroService.JPA.TDenominacionJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DenominacionJPADAOImplementation implements IDenominacionJPA{

    @Autowired
    EntityManager entityManager;
    
    @Override
    public Result GetAll() {
        Result result = new Result();
        try {
            
            TypedQuery<TDenominacionJPA> queryDenominacion = entityManager.createQuery("FROM TDenominacionJPA", TDenominacionJPA.class);
            List<TDenominacionJPA> denominaciones = queryDenominacion.getResultList();
            
            result.object = denominaciones;
            result.correct = true;
            result.status = 200;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }
        
        return result;
    }

}
