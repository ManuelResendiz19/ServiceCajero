
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOCUENTA")
public class TipoCuentaJPA {

    @Id
    @Column(name= "idtcuenta")
    private int IdTCuenta;
    
    @Column(name = "tipo")
    private String Tipo;

    public int getIdTCuenta() {
        return IdTCuenta;
    }

    public void setIdTCuenta(int IdTCuenta) {
        this.IdTCuenta = IdTCuenta;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
}
