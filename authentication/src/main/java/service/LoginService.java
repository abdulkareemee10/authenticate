package service;

import entity.Login;
import entity.Signup;
import org.springframework.stereotype.Service;
import repository.SignupRepository;

import java.util.List;
import java.util.Optional;

@Service

public class LoginService {

    private SignupRepository signupRepository;

    public String saveLogins(Signup signup){
        signupRepository.save(signup);
        return "sign up successfull";
    }

    public Optional<Signup> getById(Long id){
       Optional<Signup> signup1 =  signupRepository.findById(id);

       return signup1;
    }

    public List<Signup> getAll(){
        List<Signup> getSignup = signupRepository.findAll();
        return getSignup;
    }

    public String deleteById(Long id){

        signupRepository.deleteById(id);

        return "user deleted successfully";


        }

    public String logins(Signup signup, Login login) {
    if (signup.getEmail() == login.getUsername() && signup.getPassword() == login.getPassword()) {

        //creat token
       return "login was successfull";
    }else {
        return "username or password is incorrect";
    }
}
}
