package com.pruebaBBDDNew.pruebaBBDDNew.service;

import com.pruebaBBDDNew.pruebaBBDDNew.dao.DateTimeRepository;
import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DateTimeService {


    @Autowired
    DateTimeRepository dateTimeRepository;

    public List<DateTime> list() {return dateTimeRepository.findAll();}

    public Optional<DateTime> getOne(long id){ return dateTimeRepository.findById(id);}

    public List<DateTime> getAllByDate(String date){return dateTimeRepository.findAllByDate(date);}

    public void save(DateTime dateTime){
        System.out.println("DateService: " + dateTime.getDate() + ", TimeService: " + dateTime.getTime());
        dateTimeRepository.save(dateTime);}

    public void delete(long id){ dateTimeRepository.deleteById(id);}

    public boolean existsById(long id){return dateTimeRepository.existsById(id);}

    public boolean existsByDate(String date){return dateTimeRepository.existsAllByDate(date);}



}
