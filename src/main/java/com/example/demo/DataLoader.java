package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    CatergoryRepository catergoryRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        Car car1 = new Car("Honda", "Accord", "2005");
        Car car2 = new Car("Toyota", "Camry", "2016");

        Set<Car> carSet3 = new LinkedHashSet<>();
        carSet3.add(car1);
        carSet3.add(car2);

        Catergory catergory1 = new Catergory("Truck");
        catergoryRepository.save(catergory1);

        Catergory catergory2 = new Catergory("SUV");
        catergoryRepository.save(catergory2);

        Catergory catergory3 = new Catergory("Hatchbacks");
        car1.setCatergory(catergory3);
        car2.setCatergory(catergory3);
        catergory3.setCars(carSet3);
        catergoryRepository.save(catergory3);

        Catergory catergory4 = new Catergory("Cyclecars");
        catergoryRepository.save(catergory4);
    }
}
