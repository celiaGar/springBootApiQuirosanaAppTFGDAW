package com.pruebaBBDDNew.pruebaBBDDNew.controller;

import com.pruebaBBDDNew.pruebaBBDDNew.dto.Mensaje;

import com.pruebaBBDDNew.pruebaBBDDNew.dto.ShoppingDto;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.Shopping;
import com.pruebaBBDDNew.pruebaBBDDNew.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import com.pruebaBBDDNew.pruebaBBDDNew.dto.DateTimeDto;



import java.util.List;

@RestController
@RequestMapping("/api/shopping")
@CrossOrigin(origins = "http://localhost:4200")

public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @CrossOrigin
    @GetMapping("/listado")
    public ResponseEntity<List<Shopping>> List(){
        List<Shopping> list = shoppingService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping(value = "/crear", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody ShoppingDto shoppingDto){
        System.out.println("esto me llega" + shoppingDto.getPromociones() + " - " + shoppingDto.getTotal());
        Shopping shopping = new Shopping(shoppingDto.getPromociones(), shoppingDto.getTotal(), shoppingDto.getUserId(), shoppingDto.getPagado());

        shoppingService.save(shopping);
        return new ResponseEntity<>(new Mensaje("La compra ha sido creada."), HttpStatus.OK);
    }

}


