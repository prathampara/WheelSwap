package com.app.entity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cars")
public class Cars {
        //    http://localhsot:8080/api/v1/cars
        @PostMapping("/add-car")
        public String addCars(){
            return "added";
        }

    }
