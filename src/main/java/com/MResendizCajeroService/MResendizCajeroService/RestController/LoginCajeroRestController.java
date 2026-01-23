
package com.MResendizCajeroService.MResendizCajeroService.RestController;

import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;
import com.MResendizCajeroService.MResendizCajeroService.Service.LoginCajeroService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cajero")
public class LoginCajeroRestController {

    @Autowired
    private LoginCajeroService loginCajeroService;

    @PostMapping("/loginCajero")
    public ResponseEntity<Result> LogCajero(@RequestBody Map<String, Object> sp) {
        Result result = new Result();
        try {
            String noCuenta = (String) sp.get("NoCuenta");
            String pin = (String) sp.get("PIN");
            Integer idCajero = Integer.valueOf(sp.get("IdCajero").toString());

            result = loginCajeroService.loginCajero(noCuenta, pin, idCajero);

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.status = 500;
        }

        return ResponseEntity.status(result.status).body(result);
    }
}

