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
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public class Station{
    private String name;
    static Admin A1= new Admin("Admin", "1234");
    static Admin A2= new Admin ("Admina", "4321");
    static ArrayList<Admin> adminAccounts = new ArrayList<Admin>(Arrays.asList(A1,A2));
    static Passenger P1= new Passenger("Hanin", "1234");
    static Passenger P2= new Passenger("Farah", "1234");
    static Passenger P3= new Passenger("Yousef", "1234");
    static Passenger P4= new Passenger("Ahmed", "1234");
    static ArrayList<Passenger> passengerAccounts = new ArrayList<Passenger>(Arrays.asList(P1,P2,P3,P4));
    static Train tOct = new Train(new Route("6th of October"),33);
    static Train tCap = new Train(new Route("6th of October"),30);
    static ArrayList <Train> trains = new ArrayList<Train>(Arrays.asList(tOct, tCap));
   

 
    public Station() {
        name = " ";
    }

    public Station(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
