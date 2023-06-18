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
import java.util.Scanner;
public class MonoRailBookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
       Scanner input= new Scanner (System.in);
       Admin admin= new Admin();
       Passenger passenger= new Passenger();
           System.out.println(Account.adminAccounts);
       while(true){
       System.out.println("Welcome to the Cairo Monorail System \n Are you \n 1. An Admin \n 2. A Passenger");
       int x = input.nextInt();
       switch(x) {
           case 1:
               admin.login();
               break;
           case 2:
                
               passenger.login();
               break;
           default:
               System.out.println("You must be an admin or a passenger");
               break;
    }  
       }
}
}
