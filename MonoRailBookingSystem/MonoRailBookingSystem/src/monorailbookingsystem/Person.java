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
public abstract class Person {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int telephoneNumber;
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return ID;
    }
     public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
     public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return lastName;
    }
     public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
     public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
     
    public void setTelephonNumber(int telephoneNumber){
        this.telephoneNumber = telephoneNumber;
    }
    public int getTelephoneNumber(){
        return telephoneNumber;
    }
    public abstract void login();
    @Override
    public String toString() {
        return "Person{" + "ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", telephoneNumber=" + telephoneNumber + '}';
    }

    
}
