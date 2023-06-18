/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import static monorailbookingsystem.TimeSlots.seats;

/**
 *
 * @author Farah
 */
public class Train {
    private AtomicInteger count= new AtomicInteger(1);
    private int ID;
    private Route route;
    private double runningTime;
    private TimeSlots [] timeSlot= new TimeSlots[24];
  static Train tOct = new Train(Route.rOct, 300);
  static Train tCap = new Train(Route.rCap, 400);
 static ArrayList <Train> trains = new ArrayList<Train>(Arrays.asList(tOct, tCap));

    public Train() {
        ID = count.incrementAndGet();
        route = null;
        runningTime = 0;
         for(int i=0; i<=80; i++){
            Seat s= new Seat();
            seats.add(s);
        }
    }

    public Train( Route route, double runningTime) {  
        ID = count.incrementAndGet();
        this.route = route;
        this.runningTime = runningTime;
         for(int i=0; i<=80; i++){
            Seat s= new Seat();
            seats.add(s);
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

    public TimeSlots[] getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlots[] timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    //public int getTimeSlotIndex(){
         
    //}
  public void chooseSeat(int num){
      Seat s= seats.get(num-1);
      if(s.isAvailable(s))
          s.setStatus(false);        
  }

public boolean checkCapacity(int index){
    int i =0;
    
while(i< timeSlot[index].seats.size()){
    if(timeSlot[index].seats.get(i).getStatus() == false){
        i++;
    }
    else if(timeSlot[index].seats.get(i).getStatus() == true){
    seats.get(i).setStatus(false);
    return true;
    }
}
return false;
}
 
}
