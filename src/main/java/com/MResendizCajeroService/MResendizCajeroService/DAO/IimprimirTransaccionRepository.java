

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.TransaccionesJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IimprimirTransaccionRepository extends JpaRepository<TransaccionesJPA, Integer>{
    
    @Procedure(procedureName = "ImprimirTransaccion")
    String imprimir(@Param("pIdCajero") Integer IdCajero);
}