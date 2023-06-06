package com.pruebaBBDDNew.pruebaBBDDNew.controller;

import com.pruebaBBDDNew.pruebaBBDDNew.dto.Mensaje;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaBBDDNew.pruebaBBDDNew.entity.User;
import com.pruebaBBDDNew.pruebaBBDDNew.dto.UserDto;
import com.pruebaBBDDNew.pruebaBBDDNew.service.UserService;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping("/listado")
    public ResponseEntity<List<User>> List(){
        List<User> list = userService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    //había puesto el @ModelAttribute detrás del requestbody
    @CrossOrigin
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){

        User user = new User(userDto.getNombre(), userDto.getApellidos(), userDto.getDireccion(), userDto.getEmail(), userDto.getTelefono(), userDto.getPassword(), userDto.getConsentimiento());

        userService.save(user);
        return new ResponseEntity<>(new Mensaje("El ususario ha sido creado."), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        // Si no existe el id, el usuario no existe
        if(!userService.existsById(id))
            return new ResponseEntity<>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);

        //cojo el usuario de la bbdd según su id y lo meto en una variable user
        User user = userService.getOne(id).get();
        //seteo ese user con los datos que me pasan del form
        user.setNombre(userDto.getNombre());
        user.setApellidos(userDto.getApellidos());
        user.setDireccion(userDto.getDireccion());
        user.setEmail(userDto.getEmail());
        user.setTelefono(userDto.getTelefono());
        user.setPassword(userDto.getPassword());
        user.setConsentimiento(userDto.getConsentimiento());

        // actualizo el user en la BD
        userService.save(user);
        return new ResponseEntity<>(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }

    @RequestMapping(value = "/actualizar/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> updateUserOptions(@PathVariable("id") long id) {
        // Configura los encabezados de respuesta para permitir las solicitudes OPTIONS
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "PUT, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Max-Age", "3600");

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }


    @CrossOrigin
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if(!userService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El usuario no existe"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity<>(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }

}
