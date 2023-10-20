package controller;

import entity.Login;
import entity.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.SignupRepository;
import service.LoginService;

import java.util.List;

@RestController
@RequestMapping("/testing")

public class AppController {

    @Autowired
    private SignupRepository signupRepository;

    @Autowired
    private LoginService loginService;


    @PostMapping("/post")
    public String save(@RequestBody Signup signup){

        return loginService.saveLogins(signup);


    }

    @GetMapping("/get")
public List<Signup> getAll(){
        return loginService.getAll();
    }

    @DeleteMapping("/delete/{id}")
        public String deleteById(@PathVariable("id") Long id){

          loginService.deleteById(id);

          return "user deleted successfully";


    }
}
