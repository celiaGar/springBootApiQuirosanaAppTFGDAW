package com.pruebaBBDDNew.pruebaBBDDNew.dao;

import com.pruebaBBDDNew.pruebaBBDDNew.entity.DateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DateTimeRepository extends JpaRepository<DateTime, Long>{

    //busca citas (horas) por fecha
    List<DateTime> findAllByDate(String date);
    boolean existsAllByDate(String date);



}
