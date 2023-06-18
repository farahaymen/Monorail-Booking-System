/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Farah
 */
public class Admin extends Person{
    Scanner input = new Scanner(System.in);
    Account acc = new Account();
     public void editAccount(){
        
    }
     public void addTrain(){
                       System.out.println("Choose one of the following routes: /n 1. October Route. /n 2. New Adminstrative Capital Route.");
                       int x = input.nextInt();
                       if(x !=1 || x!=2){
                           System.out.println("Please enter an appropriate number: ");
                           x = input.nextInt();
                       }
                       Route r = new Route();
                       r = Route.routes.get(x-1);
                       System.out.println("Please enter The Running Time: ");
                       int runningTime = input.nextInt();
                       Train t = new Train( r, runningTime);
                       Train.trains.add(t);
    }
    
    public void removeTrain(){
        System.out.println("Please enter the Train ID: ");
        int id = input.nextInt();
        for(int i = 0; i < Train.trains.size();i++){
        Train t = Train.trains.get(i);
        if(t.getID() == id)
            Train.trains.remove(i);
        }
    }
    
    public void updateTrain(){
        System.out.println("Please enter the Train ID that needs to be updated: ");
        int id = input.nextInt();
        for(int i = 0; i < Train.trains.size();i++){
        Train t = Train.trains.get(i);
        if(t.getID() == id){
                System.out.println("Choose the attribute that needs to be updated: \n 1. route.\n 2. running Time./n");
                int x = input.nextInt();
                switch(x){
                    case 1:
                        System.out.println("Choose one of the following routes: /n 1. October Route. /n 2. New Adminstrative Capital Route.");
                        int y = input.nextInt();
                        Route newRoute = new Route();
                        newRoute = Route.routes.get(y-1);
                        t.setRoute(newRoute);
                        break;  
                    case 2:
                         System.out.println("Enter new Running Time: ");
                        int newRunningTime = input.nextInt();
                        t.setRunningTime(newRunningTime);
                        break;     
                }
                Train.trains.set(i, t);
        }
        }
    }
    
    public void generateReport(Train Train, Ticket Ticket){
        
    }
    
    @Override
    public void login(){
        int x;
       System.out.println("Please enter your Username: ");
       String user = input.next();
        System.out.println("Please enter your Password: ");
       String pass = input.next();
       acc.setUserName(user);
       acc.setPassword(pass);
       while( acc.validateAdmin(acc)){
       System.out.println("Please choose an option: ");
           System.out.println("1. Manage Account. \n 2. Add Train. \n 3.Remove Train. \n 4. Update Train. \n 5. Generate Report. \n 6. Exit.");
           x = input.nextInt();
           switch(x){
                   case 1:
                       editAccount();
                       break;
                   case 2:
                       addTrain();
                       break;
                   case 3:
                       removeTrain();
                       break;
                   case 4:
                       updateTrain();
                       break;
                   case 5:
                       //generateReport(train, ticket);
                       break;
                   case 6:
                       break;
           }  
       }
    }
}
