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
    private String destination;
    private double distance;
    private int ID;
    private String origin;
    private ArrayList<Station> station;
    static Route rOct = new Route("October",42,235,"Ramsees", Station.stationsOct);
    static Route rCap = new Route("New Capital",54,1351,"AL Sherooq", Station.stationsCap);
    static ArrayList <Route> routes = new ArrayList <Route>(Arrays.asList(rOct,rCap));

    public Route() {
    }
    public Route(String destination, double distance, int ID, String origin, ArrayList<Station> station) {
        this.destination = destination;
        this.distance = distance;
        this.ID = ID;
        this.origin = origin;
        this.station = station;
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
        return station;
    }

    public void setStation(ArrayList<Station> station) {
        this.station = station;
    }
    
}
