

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.math.BigDecimal;
import org.springframework.stereotype.Repository;

@Repository
public class IRetirarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    
    public void retiro(String NoTarjeta, Integer idCajero, Double monto) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("Retirar");

        query.registerStoredProcedureParameter("pNoTarjeta", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("pIdCajero", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("pMonto", BigDecimal.class, ParameterMode.IN);

        query.setParameter("pNoTarjeta", NoTarjeta);
        query.setParameter("pIdCajero", idCajero);
        query.setParameter("pMonto", BigDecimal.valueOf(monto));

        query.execute();
    }
}
