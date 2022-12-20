/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Entities.Cart;
import Entities.CartDetail;
import Repository.CartRepository;
import Repository.CartDetailRepository;

import com.fasterxml.jackson.core.JsonParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.util.json.JSONParser;

import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
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

    public ArrayList<String> splitString(String input) {
        ArrayList<String> result = new ArrayList<String>();
        String newString = input.replaceAll("[{}]", "");
        StringTokenizer tokens = new StringTokenizer(newString, ",");
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            result.add(token);
        }
        return result;
    }

    public String getAnswer(String input) {
        String[] data = input.split("=");
        return data[1];
    }

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartDetailRepository cartDetailRepository;

    @GetMapping("/cart")
    public String ShowCart(HttpSession session) {
        if (session.getAttribute("username") == null) {
           
            return "redirect:/home";
        }
        return "cart";

    }

    @PostMapping("/checkout")
    @ResponseBody
    public String addCart(HttpSession session, HttpServletRequest request) throws ParseException, NoSuchFieldException {
        int userId = (Integer) session.getAttribute("idUser");
        String total = request.getParameter("total");
        String listCarts = request.getParameter("listCarts");
        System.out.println("List of carts");

        Cart newCart = new Cart();
        newCart.setCustomerID(userId);
        newCart.setNote("");
        newCart.setTotal(Float.parseFloat(total));
        newCart.setDate(new Date());

        cartRepository.save(newCart);
        JSONParser jsonParser = new JSONParser(listCarts);
        ArrayList<Object> newArray = jsonParser.parseArray();
        for (Object object : newArray) {
            String item = object.toString();
            ArrayList<String> getListData = splitString(item);
            System.out.println(getListData);
            CartDetail detail = new CartDetail();
            detail.setOrderID(newCart.getOrderID());
            detail.setVegetableID(Integer.parseInt(getAnswer(getListData.get(0))));
            System.out.println(getAnswer(getListData.get(2)));
            detail.setQuantity(Integer.parseInt(getAnswer(getListData.get(2))));
            detail.setPrice(Float.parseFloat(getAnswer(getListData.get(2))) * Float.parseFloat(getAnswer(getListData.get(3))));
            cartDetailRepository.save(detail);

        }
        return "/home";
    }
}
