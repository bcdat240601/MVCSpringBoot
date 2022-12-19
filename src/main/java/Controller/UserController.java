/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Customers;
import Repository.UserRepository;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author ad
 */
@Controller
public class UserController {    
    @Autowired
    private UserRepository userRepository;
    
    
    @GetMapping("/login")
    public String ShowLogin(HttpSession session)
    {                
        if (session.getAttribute("username") != null) {
            return "redirect:/home";
        }                
        return "login";        
    }
    
    @PostMapping("/login")
    public String HandleLogin(String username, String password,HttpSession session){         
        Customers customers = userRepository.findByusernameAndPassword(username, password);
        if(customers != null) {
//            redirAttr.addFlashAttribute("username", username); 
            session.setAttribute("username", customers.getFullname());
            session.setAttribute("idUser", customers.getCustomerID());
            return "redirect:/home";
        }            
        return "login";
    }
    @GetMapping("/logout")
    public String Logout(HttpSession session){
        session.removeAttribute("username");
        return "redirect:/home"; 
    }
    @GetMapping("/register")
    public String ShowRegister(){
        return "register";
    }
    @PostMapping("/register")
    public String HandleRegister(String username, String password, String confirmpassword, Model model){
        if(!password.equals(confirmpassword)){
            model.addAttribute("error", "Confirm Password not match");
            return "register";
        }
        Customers newCustomer = new Customers();
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);
        newCustomer.setAddress(null);
        newCustomer.setCity(null);
        newCustomer.setFullname("dat");
        userRepository.save(newCustomer);
        return "redirect:/home";
    }
}
