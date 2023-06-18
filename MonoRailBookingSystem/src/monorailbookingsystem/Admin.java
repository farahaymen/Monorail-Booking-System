/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farah
 */
public class Admin extends Person{
    Scanner input = new Scanner(System.in);
 

    public Admin() {
        
        
    }

    public Admin(String firstName, String lastName, String email, String address, int telephoneNumber, String username, String password) {
        super(firstName, lastName, email, address, telephoneNumber, username, password);
    }
    public Admin(String username, String password){
        super(username, password);
    }

    
    
  public static void editAccount(String name, String username, String password) {

        String curr_username = "";
        for (int i = 0; i < EditAccountAdminGUI.fNames.size(); i++) {
            if (EditAccountAdminGUI.fNames.get(i).equals(name)) {
                curr_username = EditAccountAdminGUI.usernames.get(i);
            }
        }

        for (int i = 0; i < EditAccountAdminGUI.usernames.size(); i++) {
            if (EditAccountAdminGUI.usernames.get(i).equals(curr_username)) {
                String newString = username + "#" + password;
                try {
                    File file = new File("D:\\PersonInfo.txt");
                    String old = "";
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null) {
                        old = old + line + System.lineSeparator();
                        line = reader.readLine();
                    }
                    String newContent = old.replaceAll(EditAccountAdminGUI.usernames.get(i) + "#" + EditAccountAdminGUI.passwords.get(i), newString);
                    FileWriter writer = new FileWriter(file);

                    writer.write(newContent);
                    reader.close();
                    writer.close();
                    Station.adminAccounts.add(new Admin(username,password));

                } catch (IOException e) {
                    System.out.println("An Error Occured");
                }
            }
        }

    }
public static void addTrain(String runningTime, boolean octFlag, boolean capFlag) {
        String data = "";
        try {
            File file = new File("D:\\Trains.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
            }
            scanner.close();
            FileWriter f = new FileWriter("D:\\Trains.txt", true);
            BufferedWriter bw = new BufferedWriter(f);
            int ID = Integer.parseInt(data.substring(0, data.indexOf("#"))) + 1;
            if (octFlag) {
                Route route= new Route("October Route");
                Station.trains.add(new Train(route,Double.parseDouble(runningTime)));
                bw.write(String.valueOf(ID) + "#" + runningTime + "#6October");
                bw.newLine();
                bw.close();
            
            } else if (capFlag) {
                Route route= new Route("New Capital Route");
                Station.trains.add(new Train(route,Double.parseDouble(runningTime)));
                bw.write(String.valueOf(ID) + "#" + runningTime + "#NewCapital");
                bw.newLine();
                bw.close();
              
            }
            f.close();
           
        } catch (IOException ex) {
            System.out.println("An Error Occurred.\n");
        }
    }

    public static void removeTrain(String ID) {
        try {
            File file = new File("D:\\Trains.txt");
            Scanner scanner = new Scanner(file);
            String str = "";
            String lineToRemove = "";
            String data = "";
            while (scanner.hasNextLine()) {
                data = scanner.nextLine();
                if (data.substring(0, data.indexOf("#")).equals(ID)) {
                    lineToRemove = data;
                    break;
                }
            }
            scanner.close();
            File fnew = new File("D:\\Temp.txt");
            FileWriter fw = new FileWriter(fnew, true);
            BufferedWriter bw = new BufferedWriter(fw);
            Scanner scanner2 = new Scanner(file);
            while (scanner2.hasNextLine()) {
                str = scanner2.nextLine();
                if (str.equals(lineToRemove)) {
                    continue;
                }
                bw.write(str);
                bw.newLine();
            }
            for(int i =0; i<Station.trains.size(); i++){
            if(Station.trains.get(i).getID()== Integer.parseInt(ID)){
                Station.trains.remove(i);
            }
                    }
            scanner2.close();
            bw.close();
            file.delete();
            File temp = new File("D:\\Trains.txt");
            fnew.renameTo(temp);
            fw.close();

        } catch (IOException ex) {
            System.out.println("An Error Occured.\n");
        }
    }
    
    
   public void updateTrain(){
//        System.out.println("Please enter the Train ID that needs to be updated: ");
//        int id = input.nextInt();
//        for(int i = 0; i < Station.trains.size();i++){
//        Train t = Station.trains.get(i);
//        if(t.getID() == id){
//                System.out.println("Choose the attribute that needs to be updated: \n 1. route.\n 2. running Time.\n");
//                int x = input.nextInt();
//                switch(x){
//                    case 1:
//                        System.out.println("Choose one of the following routes: \n 1. October Route. \n 2. New Adminstrative Capital Route.");
//                        int y = input.nextInt();
//                        Route newRoute = new Route();
//                        newRoute = Station.routes.get(y-1);
//                        t.setRoute(newRoute);
//                        System.out.println("Thank You! Route Changed.");
//                        break;  
//                    case 2:
//                         System.out.println("Enter new Running Time: ");
//                        int newRunningTime = input.nextInt();
//                        t.setRunningTime(newRunningTime);
//                        System.out.println("Thank You@ Running Time Changed.");
//                        break;     
//                }
//                Station.trains.set(i, t);
//        }
//        }
    }
    
   public int generateReport(String route, int timeslot ) throws Exception{
         try{
         int numOfPassengers;
          if("October Route".equals(route)){
              for(int i=0; i<Station.trains.size();i++){
               if(Station.trains.get(i).getRoute().getName().equals(route)){
           numOfPassengers = Station.trains.get(i).calcCapacity(timeslot);
           return numOfPassengers;
          }
          }
          }
          else{
          for(int i=0; i<Station.trains.size();i++){
               if(Station.trains.get(i).getRoute().getName().equals(route)){
           numOfPassengers = Station.trains.get(i).calcCapacity(timeslot);
           return numOfPassengers;
          }
          }
          }
          }
            catch(Exception e){
                System.out.println("Couldn't generate report");
            }
         return 0;
    }
    
    @Override
    public  boolean login(String user, String pass){
         try {
            File file = new File("D:\\AdminAccounts.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (user.equals(data.substring(0, data.indexOf(" "))) && pass.equals(data.substring(data.indexOf(" ") + 1))) {
                    scanner.close();
                    return true;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occured.\n");
            e.printStackTrace();
        }
        return false;
   
    }

 @Override
    public boolean equals(Object o){
    Admin a = (Admin) o;
    return a.getUsername().equals(this.getUsername()) && a.getPassword().equals(this.getPassword());
        }
}
