package com.varun.sweets.global;

import java.util.*;

import com.varun.sweets.entity.Product;

public class GlobalData {
    
    public static List<Product> cart;
    static {
        cart = new ArrayList<Product>();
    }
}
