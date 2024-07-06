
package com.tienda.tienda.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public interface UsuarioDetailsService {
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
