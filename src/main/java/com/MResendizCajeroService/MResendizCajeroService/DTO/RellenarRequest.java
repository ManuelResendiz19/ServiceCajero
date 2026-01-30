
package com.MResendizCajeroService.MResendizCajeroService.DTO;


public class RellenarRequest {

    private Integer idCajero;
    private Integer idDenom;
    private Integer cantidad;

    public RellenarRequest() {
    }

    public Integer getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public Integer getIdDenom() {
        return idDenom;
    }

    public void setIdDenom(Integer idDenom) {
        this.idDenom = idDenom;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
