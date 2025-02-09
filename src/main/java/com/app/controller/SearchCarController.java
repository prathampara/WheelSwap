package com.app.controller;
import com.app.entity.cars.Car;
import com.app.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/search-car")
    public class SearchCarController {

        private CarRepository carRepository;

        public SearchCarController(CarRepository carRepository) {
            this.carRepository = carRepository;
        }
        // http://localhost:8080/api/v1/search-car/cars?param=
        @GetMapping("/cars")
        public List<Car> searchCars(
                @RequestParam String param
        ){
            return carRepository.searchCar(param);
        }
    }
