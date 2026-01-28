
package com.MResendizCajeroService.MResendizCajeroService.Service;


import com.MResendizCajeroService.MResendizCajeroService.DAO.IUsuarioJPARepository;
import com.MResendizCajeroService.MResendizCajeroService.JPA.UsuarioJPA;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UsuarioDetailsJPAService  implements UserDetailsService{

    private final IUsuarioJPARepository iUsuarioJPARepository;
    
    public UsuarioDetailsJPAService(IUsuarioJPARepository iUsuarioJPARepository){
        this.iUsuarioJPARepository = iUsuarioJPARepository;
    }
   
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        UsuarioJPA usuario =  iUsuarioJPARepository.findByUserName(userName);
        if (usuario == null) {
        System.out.println("Usuario NO encontrado con username: " + userName);
        throw new UsernameNotFoundException("Usuario no encontrado: " + userName);
    }

    System.out.println("Usuario encontrado: " + usuario.getUserName());
        
        List<GrantedAuthority> authorities = List.of(
        new SimpleGrantedAuthority("ROLE_" + usuario.getRolJPA().getNombreRol().toUpperCase())
        );
        
        return User.withUsername(usuario.getUserName())
                .password(usuario.getPassword())
                .authorities(authorities)
                .build();
    }

}