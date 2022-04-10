package com.ccb.test;

import com.ccb.entity.Cart;
import com.ccb.entity.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart = new Cart();
    public static CartItem cartItem1;
    public static CartItem cartItem2;
    public static CartItem cartItem3;
    static{
        cartItem1 = new CartItem(1, "haha1", 2, new BigDecimal(30), new BigDecimal(60));
        cartItem2 = new CartItem(2, "haha2", 2, new BigDecimal(3), new BigDecimal(6));
        cartItem3 = new CartItem(3, "haha3", 10, new BigDecimal(30), new BigDecimal(300));
    }
    @Test
    public void addItem() {
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            System.out.println(entry);
        }
    }

    @Test
    public void deleteItem() {
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.deleteItem(1);
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            System.out.println(entry);
        }
    }

    @Test
    public void clear() {
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.clear();
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            System.out.println(entry);
        }
    }

    @Test
    public void updateCartItem() {
        cart.addItem(cartItem1);
        cart.addItem(cartItem2);
        cart.updateCartItem(2, 100);
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            System.out.println(entry);
        }
        System.out.println(cart.getTotalCount());
        System.out.println(cart.getTotalPrice());
    }
}