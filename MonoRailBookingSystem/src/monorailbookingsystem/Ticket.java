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
  
    private static int seatNumber=1;
    private boolean status;

    public Ticket() {
       seatNumber= ++seatNumber;
       status= true;
    }
 

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    //To check if the seat is available or not 
    public boolean isReserved(){
        if (status == false)
            return true;
        else 
            return false;
    }
    public boolean isAvailable(Ticket s){
        if (status== true)
            return true;
        else 
            return false;
    }

    @Override
    public String toString() {
        return "Ticket{" + "status=" + status + "Seat Number:"+ seatNumber + '}';
    }   
   
}
