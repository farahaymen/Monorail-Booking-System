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
public class Route {
    private static int count= 100;
    private String name;
    private String destination;
    private double distance;
    private int ID;
    private String origin;
    private ArrayList<Station> stations = new ArrayList<Station>();
 

    public Route() {
    }
    public Route(String name) {
        this.ID = ++count;
        this.name= name;
        if("October route".equals(name)){
        this.destination = "6th of October";
         stations.add(new Station("Boulak"));
         stations.add(new Station("EL Marioutia"));
         stations.add(new Station("6th of October"));
         this.distance = 2000;
                }
        else{
        this.destination= "Administrative Capital"; 
         stations.add(new Station("Cairo Festival City"));
         stations.add(new Station("El Choueifat"));
         stations.add(new Station("Administrative Capital"));
         this.distance = 2500;
         }
         if(name == "October route"){
         this.origin = "Boulak";
                }
        else{
        this.origin= "Cairo festival city";
         }
       
       
  
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public ArrayList<Station> getStation() {
        return stations;
    }

    public void setStation(String station) {
        stations.add(new Station(station));
    }

    @Override
    public String toString() {
        return "Route{" + "name=" + name + ", destination=" + destination + ", distance=" + distance + ", ID=" + ID + ", origin=" + origin + ", stations=" + stations + '}';
    }

    
}
