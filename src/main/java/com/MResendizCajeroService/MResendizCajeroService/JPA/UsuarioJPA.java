
package com.MResendizCajeroService.MResendizCajeroService.JPA;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UsuarioJPA {
    
    @Id
    @Column(name ="idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdUsuario;
    
    @Column(name = "nombre")
    private String Nombre;
    
    @Column(name = "apellidopaterno")
    private String ApellidoPaterno;
    
    @Column(name = "apellidomaterno")
    private String ApellidoMaterno;
    
    @Column(name = "password")
    private String Password;
    
    @ManyToOne
    @JoinColumn(name = "idrol")
    private RolJPA rolJPA;
    
}
