

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.TransaccionesJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IRetirarRepository extends JpaRepository<TransaccionesJPA, Long>{

    @Procedure(procedureName = "RETIRAR")
    void retiro(@Param("pNoCuenta") String NoCuenta, @Param("pIdCajero") Integer IdCajero,@Param("pMonto") Double Monto);
}
