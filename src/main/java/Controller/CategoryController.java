/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Category;
import Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ADMIN
 */
@Controller
public class CategoryController {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @GetMapping("/shop/category")
//    @ResponseBody
//    public String getVegetableByCategory(Model m, @RequestParam(required = false) String id)
//    {
//        int idCate = Integer.parseInt(id);
//        Iterable<Category> list = categoryRepository.findAllById(idCate);
//        System.out.println(list);
//        m.addAttribute("dataCategory", list);
//        return "shop";
//        
//    }
}
