/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Repository.CartRepository;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ADMIN
 */
@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/cart")
    public String ShowCart(HttpSession session) {
        if (session.getAttribute("username") == null) {
            return "redirect:/home";
        }
        return "cart";

    }
}
