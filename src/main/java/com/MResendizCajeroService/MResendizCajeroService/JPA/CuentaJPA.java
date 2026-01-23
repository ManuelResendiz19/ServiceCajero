
package com.MResendizCajeroService.MResendizCajeroService.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@Entity
//@NamedStoredProcedureQuery(
//    name = "LoginCajero",
//    procedureName = "LoginCajero",
//    parameters = {
//        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pNoCuenta", type = String.class),
//        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pPIN", type = String.class),
//        @StoredProcedureParameter(mode = ParameterMode.IN,  name = "pIdCajero", type = Integer.class),
//        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pMensaje", type = String.class),
//        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "pIdUsuario", type = Integer.class)
//    }
//)
@Table(name = "CUENTA")
public class CuentaJPA {
    
    @Id
    @Column(name = "idcuenta")
    private int IdCuenta;

    @Column(name = "nocuenta")
    private String NoCuenta;
    
    @Column(name = "saldo")
    private Float Saldo;
    
    @Column(name = "pin")
    private String PIN;
    
    @ManyToOne
    @JoinColumn(name = "idtcuenta")
    private TipoCuentaJPA tipoCuenta;
      
    @ManyToOne
    @JoinColumn(name = "idusuario")
    private UsuarioJPA usuarioJPA;
    
    @ManyToOne
    @JoinColumn(name = "idestado")
    private EstadoCuentaJPA estadoJPA;

    public String getNoCuenta() {
        return NoCuenta;
    }

    public void setNoCuenta(String NoCuenta) {
        this.NoCuenta = NoCuenta;
    }

    public Float getSaldo() {
        return Saldo;
    }

    public void setSaldo(Float Saldo) {
        this.Saldo = Saldo;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public UsuarioJPA getUsuarioJPA() {
        return usuarioJPA;
    }

    public void setUsuarioJPA(UsuarioJPA usuarioJPA) {
        this.usuarioJPA = usuarioJPA;
    }

    public TipoCuentaJPA getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuentaJPA tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public EstadoCuentaJPA getEstadoJPA() {
        return estadoJPA;
    }

    public void setEstadoJPA(EstadoCuentaJPA estadoJPA) {
        this.estadoJPA = estadoJPA;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }
   
   
}
