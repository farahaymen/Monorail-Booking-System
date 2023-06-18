/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;
import java.util.*;

/**
 *
 * @author Farah
 */
import java.io.*;

public class Booking implements Serializable {
   static private int count=0;
    private int ID;
    private String Pusername; //Passenger username
    private String date;
    private String origin;
    private String destination;
    private Train train;
    private String time;
    private double totalPrice;
   static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    public Booking( String Pusername,String date, String origin, String destination, String route, int ticket, String time,double totalPrice) {
        this.ID = ++count;
        this.date = date;
        this.origin = origin;
        this.destination = destination;
        this.train = new Train();
        train.setRoute(new Route(route));
        this.time = time; 
        this.totalPrice= totalPrice;
        for(int i =0; i<ticket; i++){
        tickets.add(new Ticket());
        }
        this.Pusername= Pusername;
    }
    

    public Booking() {
        this.ID = ++count;
        date= " ";
        origin=" ";
        destination= " ";   
        train= null;
        time = " ";
      
    }

      public String getPusername() {
        return Pusername;
    }

    public void setPusername(String Pusername) {
        this.Pusername = Pusername;
    }
      public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount() {
        count++;
    }
   
    public int getID() {
        return ID;
    }

    public void setID() {
          ID= getCount();
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

    public ArrayList<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(Ticket ticket) {
        tickets.add(ticket);
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
        while(i < Station.trains.get(0).getTimeSlot().length){
            if(t == i){
            break;
            }
            i++;
        }
        Station.trains.get(0).checkCapacity(t);
    }
    
    public void bookCap(int t){
    int i = 0;
        while(i < Station.trains.get(1).getTimeSlot().length){
            if(t == i){
            break;
            }
            i++;
        }
       Station.trains.get(1).checkCapacity(t);
    }
     private void writeObject(ObjectOutputStream o) throws IOException {
        o.writeInt(ID);
        o.writeUTF(date);
        o.writeUTF(time);
        o.writeUTF(origin);
        o.writeUTF(destination);
        o.writeDouble(totalPrice);
        o.writeUTF(train.getRoute().getName());
    }
 
     private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException 
    {       
        ID = aInputStream.readInt(); 
        date = aInputStream.readUTF();
        origin = aInputStream.readUTF();
        destination= aInputStream.readUTF();
        totalPrice= aInputStream.readDouble();
        train.getRoute().setName(aInputStream.readUTF());
    }
     

    @Override
    public String toString() {
        return "*****************************************************************************************************************************************************************************\n"+
                "Booking{" + "ID=" + ID + ", date=" + date + ", origin=" + origin + ", destination=" + destination + ", train=" + train + ", time=" + time + ", totalPrice=" + totalPrice + '}'+
                "******************************************************************************************************************************************************************************\n";
    }

  

  
}
