package com.app.controller;


import com.app.entity.User;
import com.app.entity.cars.Car;
import com.app.entity.cars.CarImage;
import com.app.payload.ImageDto;
import com.app.repository.CarImageRepository;
import com.app.repository.CarRepository;
import com.app.service.BucketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private BucketService bucketService;

    public ImageController(CarImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    private CarImageRepository imageRepository;
    public ImageController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private CarRepository carRepository;
    public ImageController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

//    http://localhost:8097api/v1/images/upload/file/{bucketName}/car/{carId}
    @PostMapping(path = "/upload/file/{bucketName}/car/{carId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CarImage> uploadCarPhotos(@RequestParam MultipartFile file,
                                                    @PathVariable String bucketName,
                                                    @PathVariable Long carId
    ) {
        String url = bucketService.uploadFile(file, bucketName);
        Car car=carRepository.findById(carId).get();
        CarImage image = new CarImage();
        image.setUrl(url);
        image.setCar(car);
        CarImage savedImage=imageRepository.save(image);
        return new ResponseEntity<>(savedImage, HttpStatus.OK);
    }
}