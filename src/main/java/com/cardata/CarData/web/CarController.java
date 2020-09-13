package com.cardata.CarData.web;

import com.cardata.CarData.domain.Car;
import com.cardata.CarData.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
    public class CarController {
        @Autowired
        private CarRepository repository;

        @RequestMapping("/cars")
        public Iterable<Car> getCars() {
            return repository.findAll();
        }

//        @GetMapping("/cars/{id}")
//        ResponseEntity<Car> createCar(@RequestBody Car car) throws URISyntaxException {
//            Car result = repository.save(car);
//            return ResponseEntity.created(new URI("/api/cars" + result.getId())).body(result);
//        }


}

