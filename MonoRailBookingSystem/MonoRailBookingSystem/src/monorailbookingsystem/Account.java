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
public class Account {
    private String userName;
    private String password;
    static Account A1= new Account("Admin", "1234");
   static Account A2= new Account ("Admina", "4321");
static ArrayList<Account> adminAccounts = new ArrayList<Account>(Arrays.asList(A1,A2));
static ArrayList<Account> passengerAccounts = new ArrayList<Account>();
    public Account() {
        userName = " ";
        password = " "; 
    }
    
    public Account(String user, String pass) {
        userName = user;
        password = pass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public boolean validateAdmin(Account acc){
       for(int i = 0; i< Account.adminAccounts.size();i++){
     if(acc.equals(Account.adminAccounts.get(i)))
       return true;
     else{
            System.out.println("Invalid username or Password\n Try Again!");
            return false;
     }  
       
    }
        return false;
    }
     public boolean validatePassenger(Account acc){
        if( passengerAccounts.contains(acc))
            
        return true;
        
        else
         return false;
       
    }
    public boolean validateCreation(String user){
     for(int i = 0; i < passengerAccounts.size(); i++){
         Account a = passengerAccounts.get(i);
         if(a.getUserName() == user){
         System.out.println("Account already existent. Please try again");
        return false;
         }
         else{
            return true;    
 }
 }
     return false;

            }
    
    public void addAccount(Account acc){
        passengerAccounts.add(acc);
    }
    public void addAdmin(Account acc){
         adminAccounts.add(acc);
    }
    public void manageAccount(){
    
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", password=" + password + '}';
    }

    public boolean equals(Account acc) {
        for(int i=0; i< adminAccounts.size(); i++){
            Account a = adminAccounts.get(i);
          if(acc.getUserName()== a.getUserName() && acc.getPassword() == a.getPassword())
              return true;
              }
      return false;
    }
    
}
  