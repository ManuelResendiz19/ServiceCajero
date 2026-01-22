
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class InventarioCajeroJPA {

    @Id
    @Column(name = "idstock")
    private int IdStock;
    
    @ManyToOne
    @JoinColumn(name = "idcajero")
    private CajerosJPA cajerosJPA;
    
    @Column(name = "cantidaddisponible")
    private int CantidadDisponible;

    public int getIdStock() {
        return IdStock;
    }

    public void setIdStock(int IdStock) {
        this.IdStock = IdStock;
    }

    public CajerosJPA getCajerosJPA() {
        return cajerosJPA;
    }

    public void setCajerosJPA(CajerosJPA cajerosJPA) {
        this.cajerosJPA = cajerosJPA;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public void setCantidadDisponible(int CantidadDisponible) {
        this.CantidadDisponible = CantidadDisponible;
    }
    
    
}
