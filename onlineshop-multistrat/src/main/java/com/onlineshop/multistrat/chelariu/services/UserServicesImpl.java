package com.onlineshop.multistrat.chelariu.services;

import com.onlineshop.multistrat.chelariu.entities.Rol;
import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.RoleRepository;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServicesImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<> ();

         userRepository.findAll().forEach (userList::add);
         return userList;
    }

    @Override
    public Optional<User> find(Long id) {
        return userRepository.findById (id);
    }

    @Override
    public Long create(User user) {
        encodePassword (user);
        return userRepository.save (user).getId ();
    }

    @Override
    public Long updateById(Long id, User user) {

        Optional<User> userOptional = userRepository.findById (id);
        if(userOptional.isPresent()){
            return userRepository.save (user).getId ();
        } else {
            System.out.println ("Something went wrong!");

        }
        return id;


    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById (id);
    }

    @Override
    public void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode (user.getPassword ());
        user.setPassword (encodedPassword);
    }

    @Override
    public List<Rol> listRole() {
        return roleRepository.findAll ();
    }
}
