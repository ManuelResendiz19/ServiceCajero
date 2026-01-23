
package com.MResendizCajeroService.MResendizCajeroService.DTO;


public class RellenarRequest {

    private Integer IdCajero;
    private Integer IdDenom;
    private Integer Cantidad;

    public Integer getIdCajero() {
        return IdCajero;
    }

    public void setIdCajero(Integer IdCajero) {
        this.IdCajero = IdCajero;
    }

    public Integer getIdDenom() {
        return IdDenom;
    }

    public void setIdDenom(Integer IdDenom) {
        this.IdDenom = IdDenom;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
   
}
