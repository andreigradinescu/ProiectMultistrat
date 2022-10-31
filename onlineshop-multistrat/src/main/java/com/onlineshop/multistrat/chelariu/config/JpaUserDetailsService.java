package com.onlineshop.multistrat.chelariu.config;

import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.getUserByEmail (email);
       try{
           if(user != null) {
               return  new UserDetailsConfig (user);
           }
       } catch (UsernameNotFoundException exception){
           throw new UsernameNotFoundException ("Could not find with email" + email);
       }
       return loadUserByUsername (email);
       // return new org.springframework.security.core.userdetails.User (user.getEmail (), user.getPassword (), user.get);
    }
}
