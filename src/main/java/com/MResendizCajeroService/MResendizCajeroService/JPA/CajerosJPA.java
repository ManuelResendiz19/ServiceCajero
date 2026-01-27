package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAJEROS")
public class CajerosJPA {

    @Id
    @Column(name = "idcajero")
    private int IdCajero;

    @Column(name = "estado")
    private String Estado;

    @Column(name = "ubicacion")
    private String Ubicacion;

    @Column(name = "capacidadmax")
    private int CapacidadMax;

    public int getIdCajero() {
        return IdCajero;
    }

    public void setIdCajero(int IdCajero) {
        this.IdCajero = IdCajero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getCapacidadMax() {
        return CapacidadMax;
    }

    public void setCapacidadMax(int CapacidadMax) {
        this.CapacidadMax = CapacidadMax;
    }

}
