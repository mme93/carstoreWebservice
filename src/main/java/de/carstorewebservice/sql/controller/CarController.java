package de.carstorewebservice.sql.controller;

import de.carstorewebservice.sql.model.Car;
import de.carstorewebservice.sql.repository.CarRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @PostMapping("/car/load")
    public Car getLoadedCar(@RequestBody LicensePlate mark){
        System.err.println(mark.getMark());
        for(Car car:repository.findAll()){
            if(mark.getMark().equals(car.getKennzeichen())){
                return car;
            }
        }
        Car car =new Car();
        car.setKennzeichen("NOT FOUND");
        return car;
    }

    @PostMapping("/car/save")
    public String saveCar(@RequestBody Car car){
       try{
           for(Car dataBaseCar:repository.findAll()){
               if(dataBaseCar.getKennzeichen().equals(car.getKennzeichen())){
                   return "Car Allready exist!";
               }
           }
           repository.saveAndFlush(car);
           return "Success";
       }catch (Exception e){
           return e.getMessage();
       }
    }

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class LicensePlate{
    String mark;
}