package de.carstorewebservice.sql.repository;


import de.carstorewebservice.sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    default List<User> findByLastName(String lastName) {
        return null;
    }

    User findById(long id);
}

