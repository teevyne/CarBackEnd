package com.cardata.CarData.repository;

import com.cardata.CarData.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByFirstName(String firstName);
    Owner findByLastName(String lastName);
}
