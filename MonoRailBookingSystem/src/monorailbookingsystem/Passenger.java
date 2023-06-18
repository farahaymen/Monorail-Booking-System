/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monorailbookingsystem;

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static monorailbookingsystem.Station.tCap;

/**
 *
 * @author Farah
 */
public class Passenger extends Person implements Serializable {

    Scanner input = new Scanner(System.in);
    private Booking booking = new Booking();
    Booking B1 = new Booking("Hanin", "21/6/21", "Cairo Festival City", "New Capital", "New Capital Route", 3, "20", 60.0);
    Booking B2 = new Booking("Farah", "20/6/21", "Cairo Festival City", "New Capital", "New Capital Route", 3, "20", 60.0);
    ArrayList<Booking> bookings = new ArrayList<Booking>(Arrays.asList(B1, B2));

    public Passenger(String firstName, String lastName, String email, String address, int telephoneNumber, String username, String password) {
        super(firstName, lastName, email, address, telephoneNumber, username, password);
    }

    public Passenger(String username, String password) {
        super(username, password);
        for (int i = 0; i < bookings.size(); i++) {
            if (bookings.get(i).getPusername().equals(username)) {
                booking = bookings.get(i);
            }
        }

    }

    public Passenger() {
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Booking booking) {
        bookings.add(booking);
    }

    public static void bookTicket(Passenger p, String date, String route, String origin, String destination,String Time, int Tickets, double price) {

        File file = new File("D:Bookings.txt");
        try {
            FileWriter fw = new FileWriter("D:Bookings.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(date + "#" + route + "#" + origin + "#" + destination + "#" + Tickets);
            bw.newLine();
            p.bookings.add(new Booking(p.getUsername(),date,origin, destination,route, Tickets, Time, price));
            FileOutputStream fos = new FileOutputStream("D:Bookings.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p.bookings);
            oos.close();
            fos.close();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error Ocurred.\n");
        }
    }

    public double updateBooking(int ID, String date, String time, String origin, String destination, int num, String route) throws Exception {
        int x = ID;
        try {
            for (int i = 0; i < bookings.size(); i++) {
                if (x == bookings.get(i).getID()) {
                    bookings.get(i).setDate(date);
                    bookings.get(i).setTime(time);
                    if (route == "October Route") {
                        bookings.get(i).bookOct(Integer.parseInt(time));
                        for (int j = 0; j < num; j++) {
                            bookings.get(i).getTicket().add(new Ticket());
                            bookings.get(i).getTicket().get(j).setStatus(false);
                        }
                        bookings.get(i).setTotalPrice((double) num * 15);
                    } else {
                        bookings.get(i).bookCap(Integer.parseInt(time));
                        for (int j = 0; j < num; j++) {
                            bookings.get(i).getTicket().add(new Ticket());
                            bookings.get(i).getTicket().get(j).setStatus(false);
                        }
                        bookings.get(i).setTotalPrice((double) num * 20);
                    }
                }
                bookings.get(i).setOrigin(origin);
                bookings.get(i).setDestination(destination);
                booking = bookings.get(i);
            }

            try {
                FileOutputStream fos = new FileOutputStream("Bookings.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(bookings);
                oos.close();
                fos.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
            }

            return booking.getTotalPrice();
        } catch (Exception e) {
            System.out.println("NO booking exists with this ID");
            return 0.0;
        }

    }

    public void cancelBooking(int ID) {
        try {
            File file = new File("D:\\Booking.txt");
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
            for (int i = 0; i < bookings.size(); i++) {
                if (bookings.get(i).getID() == ID) {
                    bookings.remove(i);
                }
            }
            scanner2.close();
            bw.close();
            file.delete();
            File temp = new File("D:\\Booking.txt");
            fnew.renameTo(temp);
            fw.close();

        } catch (IOException ex) {
            System.out.println("An Error Occured.\n");
        }
    }

    public static void createAccount(String username, String password, String email) {
        File file = new File("D:\\PassengerAccounts.txt");
        Passenger p = new Passenger(username, password);
        try {
            FileWriter fw = new FileWriter("D:\\PassengerAccounts.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(username + "#" + password + " " + email);
            bw.newLine();
            Station.passengerAccounts.add(p);
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error Ocurred.\n");
        }
    }

    public void manageAccount(Passenger x, String user, String pass) throws Exception {
        try {
            FileInputStream ios = new FileInputStream("PassengerAccounts.txt");
            ObjectInputStream ois = new ObjectInputStream(ios);
            try {

                Passenger p = (Passenger) ois.readObject();
                Station.passengerAccounts.add(p);
                ios.close();
                ois.close();
            } catch (Exception e) {

            }
            for (int i = 0; i < Station.passengerAccounts.size(); i++) {
                if (Station.passengerAccounts.get(i).getPassword() == x.getPassword() && Station.passengerAccounts.get(i).getUsername() == x.getUsername()) {
                    Station.passengerAccounts.get(i).setUsername(user);
                    System.out.println("UserName set!");
                    Station.passengerAccounts.get(i).setPassword(pass);
                    System.out.println("Password set!");
                    try {
                        FileOutputStream fos = new FileOutputStream("PassengerAccounts.txt");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(Station.passengerAccounts);
                        oos.close();
                        fos.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Unable to connect!");
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Error connecting");
        }
    }

    @Override
    public boolean login(String user, String pass) {
        try {
            File file = new File("D:\\PassengerAccounts.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (user.equals(data.substring(0, data.indexOf("#"))) && pass.equals(data.substring(data.indexOf("#") + 1, data.indexOf(" ")))) {
                    System.out.println(data);
                    scanner.close();

                    return true;
                }

            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("An Error Occured.\n");
        }
        return false;

    }

    public static boolean validateCreation(String username, String password) {
        File file = new File("D:\\PassengerAccounts.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (username.equals(data.substring(0, data.indexOf("#"))) && password.equals(data.substring(data.indexOf("#") + 1))) {
                    return false;
                }
            }
        } catch (IOException ex) {
            System.out.println("An Error Occured.\n");
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        Passenger a = (Passenger) o;
        return a.getUsername().equals(this.getUsername()) && a.getPassword().equals(this.getPassword());
    }
}
