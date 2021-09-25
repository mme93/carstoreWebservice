package de.carstorewebservice.account.controller;

import de.carstorewebservice.sql.model.CareStoreUser;
import de.carstorewebservice.sql.model.UserID;
import de.carstorewebservice.sql.repository.CarStoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private CarStoreUserRepository repository;

    @GetMapping("/registration")
    public String reg(){
        return "Ich regestriere dich!";
    }

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
    public CareStoreUser getUser(@RequestBody UserID userID) {
        System.err.println(userID.getId());
        return repository.findById(1);
    }

    @GetMapping("/user/loadList")
    public List<CareStoreUser> getUser() {
        List<CareStoreUser> userList= new ArrayList<>();
        for(CareStoreUser user:repository.findAll()){
            userList.add(user);
        }
        return userList;
    }

    //Prüfen ob user existiert
    //wird hier nicht komplet gemacht
    @PostMapping("/user/save")
    public String saveUser(@RequestBody CareStoreUser user) throws Exception {
        try {
            for(CareStoreUser dbUser:repository.findAll()){
                if(dbUser.equals(user)){
                    return "User allready exist";
                }
            }
            repository.saveAndFlush(user);
            return "Success to save new User";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
