/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Cart;
import Repository.CartRepository;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/checkout")
    @ResponseBody
    public String addCart(HttpSession session, HttpServletRequest request) {
       int userId = (Integer) session.getAttribute("idUser");
       String total = request.getParameter("total");
       Cart newCart = new Cart();
       newCart.setCustomerID(userId);
       newCart.setNote("");
       newCart.setTotal(Float.parseFloat(total));
       newCart.setDate(new Date());
       
       cartRepository.save(newCart);
       return "/home";
    }
}
