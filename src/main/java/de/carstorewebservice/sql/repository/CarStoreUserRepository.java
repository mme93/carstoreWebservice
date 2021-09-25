package de.carstorewebservice.sql.repository;

import de.carstorewebservice.sql.model.CareStoreUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarStoreUserRepository extends JpaRepository<CareStoreUser, Long> {

    default List<CareStoreUser> findByLastName(String lastName) {
        return null;
    }

    CareStoreUser findById(long id);
}
