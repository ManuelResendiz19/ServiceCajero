

package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.UsuarioJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioJPARepository extends JpaRepository<UsuarioJPA, Integer>{

    UsuarioJPA findByUserName(String userName);

}
