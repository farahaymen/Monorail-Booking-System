/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

/**
 *
 * @author Farah
 */
public class Ticket {
    private double price;

    public Ticket() {
        price = 0.0;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" + "price=" + price + '}';
    }
    
   
}
