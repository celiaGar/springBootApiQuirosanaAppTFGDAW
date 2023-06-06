package com.pruebaBBDDNew.pruebaBBDDNew.service;


import com.pruebaBBDDNew.pruebaBBDDNew.dao.UserRepository;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class UserService {


    @Autowired
    UserRepository userRepository;

    public List<User> list() {return userRepository.findAll();}

    public Optional<User> getOne(long id){ return userRepository.findById(id);}

    public List<User> getAllByNombre(String nombre){return userRepository.findAllByNombre(nombre);}

    public void save(User user){userRepository.save(user);}

    public void delete(long id){ userRepository.deleteById(id);}

    public boolean existsById(long id){return userRepository.existsById(id);}

    public boolean existsByName(String nombre){return userRepository.existsAllByNombre(nombre);}


}
