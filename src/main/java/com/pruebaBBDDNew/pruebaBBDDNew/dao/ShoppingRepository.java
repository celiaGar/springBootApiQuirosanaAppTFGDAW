package com.pruebaBBDDNew.pruebaBBDDNew.dao;


import com.pruebaBBDDNew.pruebaBBDDNew.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface ShoppingRepository extends JpaRepository<Shopping, Long>{



}
