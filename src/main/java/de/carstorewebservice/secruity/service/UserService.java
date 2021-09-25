package de.carstorewebservice.secruity.service;



import de.carstorewebservice.sql.model.CareStoreUser;
import de.carstorewebservice.sql.repository.CarStoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CarStoreUserRepository repository;
    //Gibt den User für UserDetails zurück
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        for(CareStoreUser user:repository.findAll()){
            if(user.getEmail().equals(username)){
                User credentialUser = new User(username,user.getPassword(), new ArrayList<>());
                return credentialUser;
            }
        }
        return null;
    }
}
