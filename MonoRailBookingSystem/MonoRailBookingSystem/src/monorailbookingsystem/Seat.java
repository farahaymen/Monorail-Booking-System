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
public class Seat {
    private int number=0;
    private boolean status;

    public Seat() {
        number = number+1;
        status = true;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    //To check if the seat is available or not 
    public boolean isReserved(Seat s){
        if (s.getStatus() == false)
            return true;
        else 
            return false;
    }
    public boolean isAvailable(Seat s){
        if (s.getStatus()== true)
            return true;
        else 
            return false;
    }
}
