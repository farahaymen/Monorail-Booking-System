/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.util.*;
import java.io.Serializable;


/**
 *
 * @author Farah
 */
public class Train implements Serializable {
    static int count =1000;
    private int ID;
    private Route route;
    private double runningTime;
    private Timeslot[] timeSlot= new Timeslot[24];


    public Train() {
        ID = ++count;
        route = null;
        runningTime = 0;
         for(int i=0; i<=80; i++){
            Ticket s= new Ticket();
            Timeslot.tickets.add(s);
        }
    }

    public Train( Route route, double runningTime) {  
        this.ID= ID;
        this.route = route;
        this.runningTime = runningTime;
          for(int i=0; i<=80; i++){
            Ticket s= new Ticket();
            Timeslot.tickets.add(s);
        }
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {

        this.route = route;
    }

    public double getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(double runningTime) {
        this.runningTime = runningTime;
    }

    public Timeslot[] getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Timeslot[] timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    //public int getTimeSlotIndex(){
         
    //}
  public void chooseSeat(int num){
      Ticket t= Booking.tickets.get(num-1);
      if(t.isAvailable(t))
          t.setStatus(false);        
  }

public boolean checkCapacity(int index){
    int i =0;
    
while(i< timeSlot[index].tickets.size()){
    if(timeSlot[index].tickets.get(i).getStatus() == false){
        i++;
    }
    else if(timeSlot[index].tickets.get(i).getStatus() == true){
    Timeslot.tickets.get(i).setStatus(false);
    return true;
    }
}
return false;
}
public int calcCapacity(int index){
int count = 0;
    for(int i = 1; i< timeSlot[index].tickets.size(); i++){
    if(timeSlot[index].tickets.get(i).getStatus() == false){
        count++;
    }
 }
     return count;

}

    @Override
    public String toString() {
        return "Train{" + " ID=" + ID + ", route=" + route + '}';
    }
 
}
