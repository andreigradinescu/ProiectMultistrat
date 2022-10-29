package com.onlineshop.multistrat.chelariu.services;

import com.onlineshop.multistrat.chelariu.entities.User;
import com.onlineshop.multistrat.chelariu.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImpl implements UserServices {

    private final UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        boolean userExist = (user.getId () != null);

        if(userExist) {
            userRepository.findById (user.getId ()).get();
        } else{
            System.out.println ("Do something to encode the password!");
        }

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
}
