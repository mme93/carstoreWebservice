package de.carstorewebservice.sql.repository;


import de.carstorewebservice.sql.model.Car;
import de.carstorewebservice.sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    default List<Car> findByLastName(String lastName) {
        return null;
    }

    User findById(long id);
}