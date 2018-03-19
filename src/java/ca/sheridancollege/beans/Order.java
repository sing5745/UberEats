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
public class Order implements java.io.Serializable {
    
    private int orderno;
    private String email;
    private String address;
    private String items;
    private double total;
    private String date;

    public Order(int orderno, String email, String address, String items, double total, String date) {
        this.orderno = orderno;
        this.email = email;
        this.address = address;
        this.items = items;
        this.total = total;
        this.date = date;
    }

    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    
    public Order()
    {
        
    }

   

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" + "orderno=" + orderno + ", address=" + address + ", items=" + items + ", total=" + total + ", date=" + date + '}';
    }
    
    
    
}
