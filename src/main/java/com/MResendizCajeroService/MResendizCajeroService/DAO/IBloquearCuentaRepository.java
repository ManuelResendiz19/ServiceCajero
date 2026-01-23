

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.CuentaJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBloquearCuentaRepository extends JpaRepository<CuentaJPA, Integer>{
    
    @Procedure(procedureName = "BloquearCuenta")
    void bloqueo(@Param("pNoCuenta") String NoCuenta);
}
