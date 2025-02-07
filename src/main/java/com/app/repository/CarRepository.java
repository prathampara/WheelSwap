package com.app.repository;

import com.app.entity.cars.Brand;
import com.app.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("Select c from Car c " + " JOIN c.brand b "+ "JOIN c.transmission t "+ " where b.name=:details or t.type=:details" )
    List<Car> searchCar(
            @Param("details")String details
    );
}