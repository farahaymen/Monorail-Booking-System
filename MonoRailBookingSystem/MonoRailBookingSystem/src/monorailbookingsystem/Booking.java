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
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import static monorailbookingsystem.TimeSlots.seats;
public class Booking {
    private AtomicInteger count = new AtomicInteger(1);
    private int ID;
    private String date;
    private String origin;
    private String destination;
    private Train train;
    private Ticket ticket; 
    static ArrayList<Booking> bookings = new ArrayList<Booking> ();

    public Booking() {
        ID= count.incrementAndGet();
        date= " ";
        ticket= null;
        origin=" ";
        destination= " ";  
    }
   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void bookOct(int t){
        int i = 0;
        while(i < Train.trains.get(0).getTimeSlot().length){
            if(t == i){
            break;
            }
            i++;
        }
        Train.trains.get(0).checkCapacity(t);
    }
    
    public void bookCap(int t){
    int i = 0;
        while(i < Train.trains.get(1).getTimeSlot().length){
            if(t == i){
            break;
            }
            i++;
        }
        Train.trains.get(1).checkCapacity(t);
    }

    @Override
    public String toString() {
        return "Booking{" + "count=" + count + ", ID=" + ID + ", date=" + date + ", origin=" + origin + ", destination=" + destination + ", train=" + train + ", ticket=" + ticket + '}';
    }    
}
