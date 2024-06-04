package com.varun.sweets.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.varun.sweets.entity.Product;
import com.varun.sweets.global.GlobalData;
import com.varun.sweets.service.ProductService;


@Controller
public class CartController {
    
    @Autowired ProductService productService; 

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable int id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String removeFrmCart(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }
    
    // Checkout

    @GetMapping("/checkout")
    public String getCheckout(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";

    }

    @PostMapping("/payNow")
    public String processReceipt(Model model) {
        model.addAttribute("result", "Processed Receipt");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("Processed Item 1", "Processed Value 1");
        parameters.put("Processed Item 2", "Processed Value 2");

        model.addAttribute("parameters", parameters);

        return "orderPlaced";
    }
}