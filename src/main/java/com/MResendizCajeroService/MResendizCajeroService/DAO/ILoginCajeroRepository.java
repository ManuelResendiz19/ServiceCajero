

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class ILoginCajeroRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> loginCajero(String NoTarjeta) {

        StoredProcedureQuery query = entityManager
                .createStoredProcedureQuery("LoginCajero");

        query.registerStoredProcedureParameter("pNoTarjeta", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("pMensaje", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("pIdUsuario", Integer.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("pPinHash", String.class, ParameterMode.OUT);
        query.registerStoredProcedureParameter("pIdEstado", Integer.class, ParameterMode.OUT);

        query.setParameter("pNoTarjeta", NoTarjeta);

        query.execute();

        Map<String, Object> result = new HashMap<>();
        result.put("pMensaje", query.getOutputParameterValue("pMensaje"));
        result.put("pIdUsuario", query.getOutputParameterValue("pIdUsuario"));
        result.put("pPinHash", query.getOutputParameterValue("pPinHash"));
        result.put("pIdEstado", query.getOutputParameterValue("pIdEstado"));

        return result;
    }
}
