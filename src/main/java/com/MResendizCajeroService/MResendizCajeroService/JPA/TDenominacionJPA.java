
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TDENOMINACION")
public class TDenominacionJPA {

    @Id
    @Column(name = "iddenominacion")
    private int IdDenominacion;
    
    @Column(name = "tipodeno")
    private String TipoDeno;
    
    @Column(name = "denominacion")
    private float Denominacion;

    public int getIdDenominacion() {
        return IdDenominacion;
    }

    public void setIdDenominacion(int IdDenominacion) {
        this.IdDenominacion = IdDenominacion;
    }

    public String getTipoDeno() {
        return TipoDeno;
    }

    public void setTipoDeno(String TipoDeno) {
        this.TipoDeno = TipoDeno;
    }

    public float getDenominacion() {
        return Denominacion;
    }

    public void setDenominacion(float Denominacion) {
        this.Denominacion = Denominacion;
    }
    
    
}
