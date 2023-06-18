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
public class Station {
    private String name;
    static Station sOct1 = new Station("Boulak");
    static Station sOct2 = new Station("El Marioutia");
    static Station sOct3 = new Station("6 October");
    static Station sCap1 = new Station(" Cairo Festival");
    static Station sCap2 = new Station("El Choueifat");
    static Station sCap3 = new Station("Administrative Capital");
    static ArrayList <Station> stationsOct = new ArrayList<Station>(Arrays.asList(sOct1, sOct2, sOct3));
    static ArrayList <Station> stationsCap = new ArrayList<Station>(Arrays.asList(sCap1, sCap2, sCap3));

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

    public static ArrayList<Station> getStationsOct() {
        return stationsOct;
    }

    public static void setStationsOct(ArrayList<Station> stationsOct) {
        Station.stationsOct = stationsOct;
    }

    public static ArrayList<Station> getStationsCap() {
        return stationsCap;
    }

    public static void setStationsCap(ArrayList<Station> stationsCap) {
        Station.stationsCap = stationsCap;
    }
    
    public boolean equalsOct(Station s) {
        for(int i=0; i< stationsOct.size(); i++){
           Station temp = stationsOct.get(i);
          if(s.getName()== temp.getName())
              return true;
              }
      return false;
    }
    
    public boolean equalsCap(Station s) {
        for(int i=0; i< stationsCap.size(); i++){
           Station temp = stationsCap.get(i);
          if(s.getName()== temp.getName())
              return true;
              }
      return false;
    }
    
}
