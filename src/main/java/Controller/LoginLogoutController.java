/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Customers;
import Repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ad
 */
@Controller
public class LoginLogoutController {    
    @Autowired
    private UserRepository userRepository;
    
    
    @GetMapping("/login")
    public String ShowLogin(Model m)
    {                
        return "login";        
    }
    
    @PostMapping("/login")
    public String HandleLogin(Model m, String username, String password){ 
        System.out.println(username);
        Customers customers = userRepository.findByusernameAndPassword(username, password);
        if(customers != null) {
            return "redirect:/all";
        }            
        return "login";
    }
}
