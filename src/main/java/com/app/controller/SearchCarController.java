package com.app.controller;

import com.app.entity.cars.Brand;
import com.app.entity.cars.Car;
import com.app.repository.BrandRepository;
import com.app.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/search-car")
    public class SearchCarController {

        public SearchCarController(BrandRepository brandRepository, CarRepository carRepository) {
            this.brandRepository = brandRepository;
            this.carRepository = carRepository;
        }

        private BrandRepository brandRepository;
        private CarRepository carRepository;
        // http://localhost:8080/api/v1/search-car/cars?param=Honda
        @GetMapping("/cars")
        public List<Car> searchCars(
                @RequestParam String param
        ){
            return carRepository.searchCar(param);
        }
    }
