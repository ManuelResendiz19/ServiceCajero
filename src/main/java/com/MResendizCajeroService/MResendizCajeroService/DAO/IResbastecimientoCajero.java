

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.InventarioCajeroJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IResbastecimientoCajero extends JpaRepository<InventarioCajeroJPA, Integer>{

    @Procedure(procedureName = "REBASTECIMIENTOCajero")
    void rellenar(@Param("pIdCajero") Integer IdCajero, @Param("pIdDenom") Integer IdDenominacion, 
            @Param("pCantidad") Integer CantidadDisponible);
}
