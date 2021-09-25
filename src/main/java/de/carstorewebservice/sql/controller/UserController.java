package de.carstorewebservice.sql.controller;

import de.carstorewebservice.sql.model.User;
import de.carstorewebservice.sql.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserRepository repository;



    @PutMapping
    private String updateUser(@RequestBody long id){
        if(!repository.existsById(id)){
            return "Error: No User with ID found!";
        }
        try{
            repository.save(repository.findById(id));
            return "User with id: "+id+" Succesfull update!";
        }catch (Exception e){
            return  e.getMessage();
        }
    }

    @DeleteMapping("/user/delete")
    public String deleteUser(@RequestBody long id){
        if(!repository.existsById(id)){
            return "Error: No User with ID found!";
        }
        try{
            repository.delete(repository.findById(id));
            return "User with id: "+id+" Successfull delted!";
        }catch (Exception e){
            return  e.getMessage();
        }
    }
    @GetMapping("/user/load")
    public User getUser(@RequestBody UserID userID) {
        System.err.println(userID.getId());
        return repository.findById(1);
    }

    @GetMapping("/user/loadList")
    public List<User> getUser() {
        List<User>userList= new ArrayList<>();
        for(User user:repository.findAll()){
            userList.add(user);
        }
        return userList;
    }

    @PostMapping("/user/save")
    public String saveUser(@RequestBody User user) throws Exception {
        try {
            repository.saveAndFlush(user);
            return "Success to save new User";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserID{
    long id;
}
