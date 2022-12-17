/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Vegetable;
import Repository.VegetableRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ad
 */
@Controller
public class VegetableController {

    @Autowired
    private VegetableRepository vegtableRepository;
    
//    @GetMapping("/index")
//    public @ResponseBody Iterable<Vegetable> index(Model m)
//    {
//        return  vegtableRepository.findAll();
//        //m.addAttribute("data", list);
//        //return "home";
//        
//    }
    @GetMapping("/home")
    public String getAll(Model m)
    {
        Iterable<Vegetable> list = vegtableRepository.findAll();
        m.addAttribute("data", list);
        return "index";        
    }
    
}
