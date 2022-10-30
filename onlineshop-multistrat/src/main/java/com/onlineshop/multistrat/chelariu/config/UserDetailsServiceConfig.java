package com.onlineshop.multistrat.chelariu.config;

import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class UserDetailsServiceConfig implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.getUserByEmail (email);
        if(user != null) {
            return  new UserDetailsConfig (user);
        }
        throw new UsernameNotFoundException ("Could not find with email" + email);
    }
}
