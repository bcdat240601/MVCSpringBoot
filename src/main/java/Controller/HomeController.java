/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Vegetable;
import Repository.VegetableRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ad
 */
@Controller
public class HomeController {
    
    @Autowired
    private VegetableRepository vegtableRepository;
    @GetMapping("/home")
    public String ShowHomePage(){
        return "/index";
    }
    @GetMapping("/hint")
    public @ResponseBody String ShowHint(Model model, HttpServletRequest request){
        String name = request.getParameter("valueInput");
        String output;        
        Iterable<Vegetable> list = vegtableRepository.getVegetableByNameforSearching(name);
        Integer countLiTag = 0;
        if(list != null){
            output = "<ul class='dropdown-menu' style='display:block;overflow-y: scroll;max-height: 245px'>";        
            for(Vegetable vegetable : list) {
                output += "<li><a href='" + "#"+ "'class='item'>"+ vegetable.getVegetable_name() + "</a></li>";
                countLiTag++;
            }            
            output += "</ul>";
            if (countLiTag > 0) {
                return output;
            }else
                return null;
        }
        return null;
    }
}
