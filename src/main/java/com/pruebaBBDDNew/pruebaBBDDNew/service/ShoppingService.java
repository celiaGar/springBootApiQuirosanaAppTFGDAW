package com.pruebaBBDDNew.pruebaBBDDNew.service;


import com.pruebaBBDDNew.pruebaBBDDNew.dao.ShoppingRepository;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.Shopping;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ShoppingService {



    @Autowired
    ShoppingRepository shoppingRepository;

    public List<Shopping> list() {return shoppingRepository.findAll();}

    public Optional<Shopping> getOne(long id){ return shoppingRepository.findById(id);}


    public void save(Shopping shopping){
        System.out.println("PromocionesService: " + shopping.getPromociones() + ", TotalService: " + shopping.getTotal());
        shoppingRepository.save(shopping);}

    public void delete(long id){ shoppingRepository.deleteById(id);}

    public boolean existsById(long id){return shoppingRepository.existsById(id);}



}
