package com.app.repository;

import com.app.entity.cars.Brand;
import com.app.entity.cars.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
//    @Query("Select c from Car c " + " JOIN c.brand b "+ "JOIN c.transmission t "+ "JOIN c.model m"+ "JOIN c.year y" +" where b.name=:details or t.type=:details or m.name=:details or y.year>=:year" )
//    List<Car> searchCar(
//            @Param("details")String details
//    );
//}
//    @Query("SELECT c FROM Car c " +
//        "LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "WHERE LOWER(c.model.model) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
//            " OR LOWER(c.fuel.fuelType) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
//            " OR LOWER(c.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
//            "OR LOWER(c.transmission.type) LIKE LOWER(CONCAT('%', :keyword, '%')) ") +
//        " OR CAST(c.year.year AS String) LIKE CONCAT('%', :keyword, '%')")
//
//    List<Car> searchCar(@Param("keyword") String keyword);
//}


@Query("SELECT c FROM Car c " +
//        "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +

        "WHERE LOWER(c.brand.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "OR LOWER(c.fuelType.fuelType) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "OR LOWER(c.model.model) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "OR LOWER(c.transmission.type) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
        "OR CAST(c.year.year AS string) LIKE CONCAT('%', :keyword, '%')")
List<Car> searchCar(@Param("keyword") String keyword);}