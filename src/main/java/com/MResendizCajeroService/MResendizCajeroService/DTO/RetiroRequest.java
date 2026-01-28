
package com.MResendizCajeroService.MResendizCajeroService.DTO;


public class RetiroRequest {
    private String NoTarjeta;
    private Integer IdCajero;
    private Double Monto;

    public String getNoTarjeta() {
        return NoTarjeta;
    }

    public void setNoTarjeta(String NoTarjeta) {
        this.NoTarjeta = NoTarjeta;
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
