
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "transacciones")
public class TransaccionesJPA {
    
    @Id
    @Column(name = "idtransaccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdTransaccion;
    
    @Column(name = "nocuenta")
    private String NoCuenta;
    
    @Column(name = "monto")
    private float Monto;
    
    @ManyToOne
    private CajerosJPA cajerosJPA;

    public int getIdTransaccion() {
        return IdTransaccion;
    }

    public void setIdTransaccion(int IdTransaccion) {
        this.IdTransaccion = IdTransaccion;
    }

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }

    public CajerosJPA getCajerosJPA() {
        return cajerosJPA;
    }

    public void setCajerosJPA(CajerosJPA cajerosJPA) {
        this.cajerosJPA = cajerosJPA;
    }
    
    
}
