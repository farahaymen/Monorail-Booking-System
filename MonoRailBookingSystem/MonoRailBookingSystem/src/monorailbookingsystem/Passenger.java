/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.util.Scanner;

/**
 *
 * @author Farah
 */
public class Passenger extends Person{
    Scanner input = new Scanner(System.in);
    private Account pAcc = new Account();
    private Booking booking = new Booking();
    
    public void bookTicket(){
        Ticket t = new Ticket();
        System.out.println("Choose The Origin: ");
        String origin = input.next();
        Station originStation = new Station(origin);   
        System.out.println("Choose The Destination: ");
        String destination = input.next();
        Station destinationStation = new Station(destination);
        
        for(int i = 0; i<Station.stationsOct.size();i++){
            Station si = Station.stationsOct.get(i);
        if(originStation == si){
        for(int j = 0; j<Station.stationsOct.size();j++){
            Station sj = Station.stationsOct.get(j);
            if(destinationStation == sj){
            System.out.println("Please Enter a date: ");
            String date = input.next();
            booking.setDate(date);
            System.out.println("Please enter Time: ");
            int Time = input.nextInt();
            booking.bookOct(Time);
            booking.setDestination(destination);
            booking.setOrigin(origin);
            t.setPrice(15);
            booking.setTicket(t);
            System.out.println("Seat Booked Successfully!");
            System.out.println(booking);
            }
            //break;
        }
        }
        else{
               System.out.println("Invalid Origin or Destination"); 
                }
        //break;      
        }
//        
//        
//        for(int i = 0; i<Station.stationsCap.size();i++){
//            Station si = Station.stationsCap.get(i);
//        if(originStation.equalsOct(si))
//            break;
//        }
//        for(int j = 0; j<Station.stationsCap.size();j++){
//            Station sj = Station.stationsCap.get(j);
//            if(destinationStation.equalsCap(sj)){
//            System.out.println("Please Enter a date: ");
//            String date = input.nextLine();
//            System.out.println("Please enter Time: ");
//            int Time = input.nextInt();
//            booking.bookCap(Time);
//            booking.setDestination(destination);
//            booking.setOrigin(origin);
//            t.setPrice(20);
//            booking.setTicket(t);
//            System.out.println("Seat Booked Successfully!");
//            System.out.println(booking);
//            break;
//            }
//        
//        }
        
        
        
        
        //if(originStation.equalsOct(originStation) && destinationStation.equalsOct(destinationStation)){
            //System.out.println("Please Enter a date: ");
            //String date = input.nextLine();
            //System.out.println("Please enter Time: ");
            //int Time = input.nextInt();
            //booking.bookOct(Time);
            //booking.setDestination(destination);
            //booking.setOrigin(origin);
            //t.setPrice(15);
            //booking.setTicket(t);
            //System.out.println("Seat Booked Successfully!");
            //System.out.println(booking);
        //}
        //else if(originStation.equalsCap(originStation) && destinationStation.equalsCap(destinationStation)){
           // System.out.println("Please Enter a date: ");
           // String date = input.nextLine();
           // System.out.println("Please enter Time: ");
           // int Time = input.nextInt();
           // booking.bookCap(Time);
           // booking.setDestination(destination);
           // booking.setOrigin(origin);
           // t.setPrice(20);
           // booking.setTicket(t);
           // System.out.println("Seat Booked Successfully!");
           // System.out.println(booking);
        //}
        //else{
         //   System.out.println("Invalid Origin or Destination.");
        //}
    }
    
   /* public void updateBooking(){
         Ticket t = new Ticket();
         Ticket t2= booking.getTicket();
        System.out.println("Please enter your booking ID ");
        int x= input.nextInt();
        for(int i=0; i<Booking.bookings.size(); i++ ){
       Booking b= Booking.bookings.get(i);
       if (b.getID()== x)
        System.out.println("Please choose the information to update\n 1.Date and Time \n 2.Origin and Destination \n 3.Seat \n 4.Number of Tickets");
       int y= input.nextInt();
       switch(y){
           case 1:
               System.out.println("Enter the new date you want to book");
               String d=input.nextLine();
               booking.setDate(d);
               System.out.println("Enter the new Time you want to book");
               String time=input.nextLine();
               booking.setTime(time);
               break;
           case 2:
              System.out.println("Enter your new origin");
              String o = input.nextLine();
              Station originStation = new Station(o);   
              System.out.println("Choose The Destination: ");
              String destination = input.nextLine();
              Station destinationStation = new Station(destination);
              if(Station.stationsOct.contains(originStation) && Station.stationsOct.contains(destinationStation)){
                   t.setPrice(15);
                   booking.setDestination(destination);
                   booking.setOrigin(o);
                   booking.setTicket(t);
                  
              }
               if(Station.stationsCap.contains(originStation) && Station.stationsCap.contains(destinationStation)){
                     t.setPrice(20);
                     booking.setDestination(destination);
                     booking.setOrigin(o);
                     booking.setTicket(t); 
               }
               break;  
          case 3:
               for(int j=0; j < Train.seats.size(); j++){
                   
               }
               break;
           case 4:
               
                break;    
       }
        
                }
        
    }*/
    public void cancelBooking(){
    
    }
    
    public void createAccount(){
        System.out.println("Please enter the username: ");
        String userName = input.next();
        if(pAcc.validateCreation(userName) == true)
            pAcc.setUserName(userName);
        System.out.println("Please enter the password: ");
        String password = input.next();
        pAcc.setPassword(password);
        pAcc.addAccount(pAcc);
        System.out.println("Account created Successfully!");
        }
       
    @Override
    public void login(){
        int x = 0;
        System.out.println("Please enter your Username: ");
       String user = input.next();
        System.out.println("Please enter your Password: ");
       String pass = input.next();
      while(pAcc.validatePassenger(pAcc)){
           System.out.println("Please choose an option: ");
           System.out.println("1. Manage Account. \n 2. Book Ticket. \n 3.Cancel Booking. \n 4. Update Booking. \n 5. View Ticket. \n 6. Exit.");
           x = input.nextInt();
           switch (x){
               case 1:
                   pAcc.manageAccount();
                   break;
               case 2:
                   bookTicket();
                   break;
               case 3:
                   cancelBooking();
                   break;
               case 4:
                   //updateBooking();
                   break;
               case 5:
                   booking.toString();
                   break;
               case 6:
                   return;
           }
       }
      while( !pAcc.validatePassenger(pAcc)){
          System.out.println("Invalid username or Password");
          System.out.println("Don't have an account? 1.create one 2.EXIT");
          int y= input.nextInt();
          switch(y){
              case 1: 
                  createAccount();
              case 2: 
                  break;
          }
          break;
      }
    }
}
