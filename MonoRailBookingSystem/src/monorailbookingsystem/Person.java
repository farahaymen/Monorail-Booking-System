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
    static private int count=100;
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int telephoneNumber;
    private String username;
    private String password;

    public Person() {
        ID= 0;
        firstName= " ";
        lastName=" ";
        email=" ";
        address= " ";
        telephoneNumber= 0;
        username= " ";
        password= " ";
    }
    

    public Person(String firstName, String lastName, String email, String address, int telephoneNumber, String username, String password) {
        this.ID = ++count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.username = username;
        this.password = password;
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
  
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public abstract boolean login(String user, String pass);

    @Override
    public String toString() {
        return "Person{" + "ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + ", telephoneNumber=" + telephoneNumber + ", username=" + username + '}';
    }
  

    
}
