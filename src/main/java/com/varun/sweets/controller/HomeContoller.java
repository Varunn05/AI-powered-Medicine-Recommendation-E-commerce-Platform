package com.varun.sweets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.varun.sweets.global.GlobalData;
import com.varun.sweets.service.CategoryService;
import com.varun.sweets.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeContoller {
    @Autowired CategoryService categoryService;
    @Autowired ProductService productService;
    
    @GetMapping({"/", "home"})
    public String getHome(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }


    @GetMapping("/shop")
    public String getShop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }   

    @GetMapping("/shop/category/{id}")
    public String getShopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("products", productService.getAllPorductsByCategoryId(id));
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String getViewProduct(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }    
}
