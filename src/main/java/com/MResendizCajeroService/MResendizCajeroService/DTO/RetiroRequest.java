
package com.MResendizCajeroService.MResendizCajeroService.DTO;


public class RetiroRequest {
    private String NoCuenta;
    private Integer IdCajero;
    private Double Monto;

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public Integer getIdCajero() {
        return IdCajero;
    }

    public void setIdCajero(Integer IdCajero) {
        this.IdCajero = IdCajero;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    
}
