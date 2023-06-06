package com.pruebaBBDDNew.pruebaBBDDNew.controller;

import com.pruebaBBDDNew.pruebaBBDDNew.dto.Mensaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import com.pruebaBBDDNew.pruebaBBDDNew.dto.DateTimeDto;
import com.pruebaBBDDNew.pruebaBBDDNew.service.DateTimeService;


import java.util.List;

@RestController
@RequestMapping("/api/dateTime")
@CrossOrigin(origins = "http://localhost:4200")
public class DateTimeController {

    @Autowired
    DateTimeService dateTimeService;

    @CrossOrigin
    @GetMapping("/listado")
    public ResponseEntity<List<DateTime>> List(){
        List<DateTime> list = dateTimeService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping(value = "/crear", produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody DateTimeDto dateTimeDto){
        System.out.println("esto me llega" + dateTimeDto.getDate() + " - " + dateTimeDto.getTime());
        DateTime dateTime = new DateTime(dateTimeDto.getDate(), dateTimeDto.getTime(), dateTimeDto.getUserId());

        dateTimeService.save(dateTime);
        return new ResponseEntity<>(new Mensaje("La cita ha sido creada."), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        if(!dateTimeService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La cita no existe"), HttpStatus.NOT_FOUND);
        dateTimeService.delete(id);
        return new ResponseEntity<>(new Mensaje("Cita eliminada"), HttpStatus.OK);
    }


    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> deleteDateTimeOptions(@PathVariable("id") long id) {
        // Configura los encabezados de respuesta para permitir las solicitudes OPTIONS y DELETE
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Methods", "DELETE, OPTIONS");
        headers.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        headers.add("Access-Control-Allow-Origin", "http://localhost:4200");
        headers.add("Access-Control-Max-Age", "3600");

        return new ResponseEntity<>(headers, HttpStatus.OK);
    }
}




