
package com.MResendizCajeroService.MResendizCajeroService.Service;

import com.MResendizCajeroService.MResendizCajeroService.DAO.ILoginCajeroRepository;
import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import jakarta.transaction.Transactional;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginCajeroService {

    @Autowired
    private ILoginCajeroRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Result loginCajero(String noCuenta, String pinIngresado, Integer idCajero) {
        Result result = new Result();

        try {
            Map<String, Object> output = repository.loginCajero(noCuenta);

            String mensajeSP = (String) output.get("pMensaje");
            Integer idUsuario = (Integer) output.get("pIdUsuario");
            String pinHashBD = (String) output.get("pPinHash");
            Integer idEstado = (Integer) output.get("pIdEstado");

            if (!"OK".equals(mensajeSP) || idUsuario == null) {
                result.correct = false;
                result.errorMessage = "CREDENCIALES_INCORRECTAS";
                result.status = 401;
                return result;
            }

            if (!passwordEncoder.matches(pinIngresado, pinHashBD)) {
                result.correct = false;
                result.errorMessage = "CREDENCIALES_INCORRECTAS";
                result.status = 401;
                return result;
            }

            if (idEstado != 1) {
                String estadoMsg = idEstado == 2 ? "CUENTA BLOQUEADA" : "CUENTA INACTIVA";
                result.correct = false;
                result.errorMessage = estadoMsg;
                result.status = 403;
                return result;
            }

            result.correct = true;
            result.object = idUsuario;
            result.status = 200;

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = "ERROR DE CONEXIÓN CON LA BASE DE DATOS";
            result.status = 500;
        }

        return result;
    }
}
