
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ESTADO")
class EstadoCuentaJPA {
    
    @Id
    @Column(name = "idestado")
    private int IdEstado;
    
    @Column(name = "nombreestado")
    private String NombreEstado;

    public int getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(int IdEstado) {
        this.IdEstado = IdEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String NombreEstado) {
        this.NombreEstado = NombreEstado;
    }
    
}
