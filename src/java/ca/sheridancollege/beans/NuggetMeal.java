/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.beans;

/**
 *
 * @author Inder
 */
public class NuggetMeal {
    private int qty;
    private String name;

    public NuggetMeal() {
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public NuggetMeal(int qty, String name) {
        this.qty = qty;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "qty=" + qty + ", name=" + name ;
    }
    
    
    
}
