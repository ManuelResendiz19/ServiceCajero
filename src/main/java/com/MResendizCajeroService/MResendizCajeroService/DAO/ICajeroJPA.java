package com.MResendizCajeroService.MResendizCajeroService.DAO;

import com.MResendizCajeroService.MResendizCajeroService.JPA.Result;


public interface ICajeroJPA {
    Result GetAllCajeros();
    Result GetByIdCajeros(int IdCajero);
}
