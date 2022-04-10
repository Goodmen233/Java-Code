package com.ccb.entity;

import java.io.CharArrayReader;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    private Integer totalCount = 0;
    private BigDecimal totalPrice = new BigDecimal(0);
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    public Integer getTotalCount() {
        totalCount = 0;// 清除上次访问的值
        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        totalPrice = new BigDecimal(0);// 清除上次访问的值
        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    // 添加商品
    public void addItem(CartItem cartItem){
        // 判断购物车里面是否有该商品
        CartItem item = items.get(cartItem.getId());
        if(item != null){
            item.setCount(item.getCount()+1);
            item.getTotalPrice();// 更新总金额
        }else{
            items.put(cartItem.getId(), cartItem);
        }
    }

    // 删除商品
    public void deleteItem(Integer id){
        items.remove(id);
    }

    // 清空购物车
    public void clear(){
        items.clear();
    }

    // 修改商品数量
    public void updateCartItem(Integer id, Integer count){
        CartItem item = items.get(id);
        item.setCount(count);
    }

    // 是否还有商品
    public boolean isEmpty(){
        return items.isEmpty();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + totalCount +
                ", totalPrice=" + totalPrice +
                ", items=" + items +
                '}';
    }
}
