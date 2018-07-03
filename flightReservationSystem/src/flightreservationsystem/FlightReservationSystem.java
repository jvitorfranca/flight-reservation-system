/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;

/**
 *
 * @author vitorfranca
 */
public class FlightReservationSystem {

    public static User Logado;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
        mongoLogger.setLevel(Level.SEVERE); 
        
        try {
        
            MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
            
            DB database = mongoClient.getDB("SystemDB");
            
            System.out.println("Connected to Database");
        
            DBCollection collection = database.getCollection("User");
            
            //inicializing Seats
            Seat[][] arraySeat1 = new Seat [20][6];
            Seat[][] arraySeat2 = new Seat [20][6];
            Seat[][] arraySeat3 = new Seat [20][6];

            for (int i = 0;i < 20;i++){

                for (int j = 0;j < 6;j++){

                    if(i<= 5){

                        arraySeat1[i][j] = new FirstClass(0);

                    }else{

                        arraySeat1[i][j] = new EconomicClass(0);

                    }


                }

            }

            for (int i = 0;i < 20;i++){

                for (int j = 0;j < 6;j++){

                    if(i<= 5){

                        arraySeat2[i][j] = new FirstClass(0);

                    }else{

                        arraySeat2[i][j] = new EconomicClass(0);

                    }


                }

            }

            for (int i = 0;i < 20;i++){

                for (int j = 0;j < 6;j++){

                    if(i<= 5){

                        arraySeat3[i][j] = new FirstClass(0);

                    }else{

                        arraySeat3[i][j] = new EconomicClass(0);

                    }


                }

            }

            //inicializing Flight1
            Flight flight1 = new Flight("010", "01", "São Paulo", "25/05/2018", "03:45", arraySeat1);
            Flight flight2 = new Flight("053", "02", "Recife", "27/05/2018", "15:30", arraySeat2);
            Flight flight3 = new Flight("130", "03", "Londres", "02/06/2018", "21:57", arraySeat3);

            Flight newFlight = flight1;

            ArrayList<Flight> arrayFlight = new ArrayList();

            arrayFlight.add(flight1);
            arrayFlight.add(flight2);
            arrayFlight.add(flight3);

            ArrayList<User> arrayUser = new ArrayList();

            //Initializing Admins

            User Admin1 = new User("Leonardo","123","123","123",123,123);
            User Admin2 = new User("Vitor","456","456","456",456,456);
            User Admin3 = new User("Jéssica","789","789","789",789,789);

            arrayUser.add(Admin3);
            arrayUser.add(Admin2);
            arrayUser.add(Admin1);

            int menuLogin = 100;
            int menuOptions = 100;
            int optionFlight;

            int row;
            int colInt = 0;

            Scanner input = new Scanner(System.in);

            String col;

            String name;
            String cpf;
            String email;
            String password;
            long cellphone;
            long credit_card;

            Seat seat = null; 

            while(menuLogin == 100 && menuOptions <= 105){

                System.out.println("====================");
                System.out.println("=   1- Log In      =");
                System.out.println("=   2- Sign Up     =");
                System.out.println("====================");

                menuLogin = input.nextInt();

                if(menuLogin == 1){

                    //Receiving e-mail entry
                    System.out.println("Email: ");

                    String emailLogin = input.next();

                    //Reciving password entry
                    System.out.println("Password: ");

                    String PasswordLogin = input.next();
                    
                    //Creating a query to find the user
                    DBObject query = new BasicDBObject("E-mail", emailLogin);
                    
                    DBCursor cursor = collection.find(query);
                    
                    //You're in the system
                    System.out.println("\nHello, " + cursor.one().get("Name") + "!");
                    
                    System.out.println("\nWhat do you want to do now?");
                    
                    while (menuOptions != 7){
                       //This is a menu
                        System.out.println("=========================");
                        System.out.println("=   1- Consult          =");
                        System.out.println("=   2- Reservate        =");
                        System.out.println("=   3- Buy              =");
                        System.out.println("=   4- Realocate        =");
                        System.out.println("=   5- Cancel           =");
                        System.out.println("=   6- Boarding Card    =");
                        System.out.println("=   7- Log Out          =");
                        System.out.println("=========================");

                        //Reading the menu's options selected
                        menuOptions = input.nextInt();

                        switch(menuOptions){

                            case 1:

                                //If case 1, we'll consult the flights
                                for (int j = 0;j < arrayFlight.size();j++){

                                    System.out.printf("\n%d - ", j);
                                    arrayFlight.get(j).printFlight();

                                }

                                System.out.println("\nPlease, inform your flight. Ex: '1'");

                                //Reading the option entry
                                optionFlight = input.nextInt();
                                
                                //Checking if the flight exist
                                if (optionFlight < 3){
                                    
                                    //Selecting the flight informed
                                    newFlight = arrayFlight.get(optionFlight);

                                    //Printing the seats of this flight
                                    newFlight.seatMap();
                                    
                                } else {
                                    
                                    System.out.println("\nSelect a existing flight\n");
                                    
                                }
                                
                                break;
                                
                            case 2:
                                
                                //If case 2, we'll reservate a seat
                                for (int j = 0;j < arrayFlight.size();j++){

                                    System.out.printf("\n%d - ", j);
                                    arrayFlight.get(j).printFlight();

                                }
                                
                                System.out.println("\nPlease, inform your flight. Ex: '1'\n");
                                
                                //Reading the option entry
                                optionFlight = input.nextInt();
                                
                                //Checking if the flight exist
                                if (optionFlight < 3){
                                    
                                    //Selecting the flight
                                    newFlight = arrayFlight.get(optionFlight);
                                    
                                    if (cursor.one().get("Seat").equals("00")){
                                        
                                        //Print the flight name and hour
                                        newFlight.printFlight();
                                     
                                        //Print the seat map
                                        newFlight.seatMap();
                                        
                                        System.out.println("\nInsert the row of yout seat. Ex: 20");
                                        
                                        //Read the row informed
                                        row = input.nextInt();
                                        
                                        System.out.println("\nInsert the collumn of your seat. Ex: C");
                                        
                                        //Read the collumn informed
                                        col = input.next();
                                        
                                        //Check if it's a first class seat or not
                                        if (row <= 6){
                                            
                                            String decision;
                                            
                                            System.out.println("\nThis is a first class seat. Do you want to buy it? [Y/N]");
                                            
                                            //Read the decision
                                            decision = input.next();
                                            
                                            //Check if the user accepted
                                            if (decision.equalsIgnoreCase("Y")){
                                                                                               
                                                //Reserve the seat
                                                seat = (FirstClass)newFlight.reservation(newFlight.getArraySeat(), row, col);
                                                
                                                //Update the user's seat value in the database
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));
                                               
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));
                                                
                                                if (col.equalsIgnoreCase("A")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 1)));
                                                    
                                                } else if (col.equalsIgnoreCase("B")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 2)));
                                                    
                                                } else if (col.equalsIgnoreCase("C")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 3)));
                                                    
                                                } else if (col.equalsIgnoreCase("D")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 4)));
                                                    
                                                } else if (col.equalsIgnoreCase("E")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 5)));
                                                    
                                                } else if (col.equalsIgnoreCase("F")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 6)));
                                                    
                                                }
                                                
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("SeatStatus", "reserved")));
                                                
                                                //Just print the new seat
                                                System.out.println((String)cursor.one().get("Seat"));
                                                
                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Reserved");

                                                }
                                                
                                            } else {
                                                
                                                //If the user denied
                                                menuOptions = 2;
                                                
                                            }
                                            
                                        } else {
                                            
                                            String decision;
                                            
                                            System.out.println("\nThis is a economic class seat. Do you want to reserve it? [Y/N]");
                                            
                                            //Read the user's decision
                                            decision = input.next();
                                            
                                            //Check if the user accepted
                                            if (decision.equalsIgnoreCase("Y")){
                                                                        
                                                //Make the reservation
                                                seat = (EconomicClass)newFlight.reservation(newFlight.getArraySeat(), row, col);
                                                
                                                //Update the user's seat value
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));
                                               
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));
                                                
                                                if (col.equalsIgnoreCase("A")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 1)));
                                                    
                                                } else if (col.equalsIgnoreCase("B")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 2)));
                                                    
                                                } else if (col.equalsIgnoreCase("C")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 3)));
                                                    
                                                } else if (col.equalsIgnoreCase("D")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 4)));
                                                    
                                                } else if (col.equalsIgnoreCase("E")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 5)));
                                                    
                                                } else if (col.equalsIgnoreCase("F")){
                                                    
                                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 6)));
                                                    
                                                }
                                                
                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("SeatStatus", "reserved")));
                                                
                                                //Print the new seat
                                                System.out.println((String)cursor.one().get("Seat"));
                                                
                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Reserved");

                                                }
                                                
                                            } else {
                                                
                                                //return to the menu if the user didn't want to reservate
                                                menuOptions = 2;
                                                
                                            }
                                            
                                        }
                                        
                                    } else {
                                        
                                        //If the user already have a reserve
                                        System.out.println("\nSorry, but you can reserve just one seat.");
                                        
                                    }
                                    
                                } else {
                                    
                                    //If the user selected that do not exist
                                    System.out.println("\nSelect a existing flight");
                                    
                                }
                                
                                break;
                                
                            case 3:
                                
                                if (!cursor.one().get("Seat").equals("00")){
                                    
                                    row = (int) cursor.one().get("RowSeat");
                                    
                                    colInt = (int) cursor.one().get("ColSeat");
                                    
                                    newFlight.buy(newFlight.getArraySeat(), row, colInt);
                                    
                                    newFlight.seatMap();
                                    
                                    collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("SeatStatus", "bought")));
                                    
                                    System.out.println("Purchase successful");
                                    
                                } else {
                                    
                                    System.out.println("\nYou must reserve first");
                                    
                                }
                                
                                break;
                                
                            case 4:
                                
                                if (!cursor.one().get("Seat").equals("00")){
                                    
                                    System.out.println("\nInsert the row of your new seat. Ex: 20");
                                        
                                    //Read the row informed
                                    row = input.nextInt();

                                    System.out.println("\nInsert the collumn of your new seat. Ex: C");

                                    //Read the collumn informed
                                    col = input.next();

                                    int rowUser = (int) cursor.one().get("RowSeat");
                                    int colUser = (int) cursor.one().get("ColSeat");

                                    if (col.equalsIgnoreCase("A")){

                                        colInt = 1;

                                    } else if (col.equalsIgnoreCase("B")){

                                        colInt = 2;

                                    } else if (col.equalsIgnoreCase("C")){

                                        colInt = 3;

                                    } else if (col.equalsIgnoreCase("D")){

                                        colInt = 4;

                                    } else if (col.equalsIgnoreCase("E")){

                                        colInt = 5;

                                    } else if (col.equalsIgnoreCase("F")){

                                        colInt = 6;

                                    }

                                    //Check if it's a first class seat or not
                                    if (row <= 6){

                                        String decision;

                                        System.out.println("\nThis is a first class seat. Do you want to buy it? [Y/N]");

                                        //Read the decision
                                        decision = input.next();

                                        //Check if the user accepted
                                        if (decision.equalsIgnoreCase("Y")){

                                            if(cursor.one().get("SeatStatus").equals("reserved")){

                                                seat = newFlight.realocateReservation(newFlight.getArraySeat(), rowUser, colUser, row, col);

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", colInt)));

                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Realocated");

                                                }

                                            } else if (cursor.one().get("SeatStatus").equals("bought")){

                                                seat = newFlight.realocatePurchase(newFlight.getArraySeat(), rowUser, colUser, row, col, colInt);

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", colInt)));

                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Realocated");

                                                }

                                            }

                                            //Just print the new seat
                                            System.out.println((String)cursor.one().get("Seat"));



                                        } else {

                                            //If the user denied
                                            menuOptions = 2;

                                        }

                                    } else {

                                        String decision;

                                        System.out.println("\nThis is a economic class seat. Do you want to reserve it? [Y/N]");

                                        //Read the user's decision
                                        decision = input.next();

                                        //Check if the user accepted
                                        if (decision.equalsIgnoreCase("Y")){

                                            if(cursor.one().get("SeatStatus").equals("reserved")){

                                                seat = newFlight.realocateReservation(newFlight.getArraySeat(), rowUser, colUser, row, col);

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", colInt)));

                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Realocated");

                                                }

                                            } else if (cursor.one().get("SeatStatus").equals("bought")){

                                                seat = newFlight.realocatePurchase(newFlight.getArraySeat(), rowUser, colUser, row, col, colInt);

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", row + col)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", row)));

                                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", colInt)));

                                                //Check if it's alright
                                                if(seat != null){

                                                    System.out.println("Realocated");

                                                }

                                            }

                                            //Print the new seat
                                            System.out.println((String)cursor.one().get("Seat"));

                                        } else {

                                            //return to the menu if the user didn't want to reservate
                                            menuOptions = 2;

                                        }

                                    }
                                    
                                } else {
                                    
                                    System.out.println("You must have a seat first");
                                    
                                }
                                
                                break;
                                
                            case 5:
                                
                                row = (int) cursor.one().get("RowSeat");
                                
                                colInt = (int) cursor.one().get("ColSeat");
                                
                                newFlight.cancel(newFlight.getArraySeat(), row, colInt);
                                
                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("Seat", "00")));
                                
                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("RowSeat", 0)));
                                
                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("ColSeat", 0)));
                                
                                collection.update(new BasicDBObject("E-mail", emailLogin), new BasicDBObject("$set", new BasicDBObject("SeatStatus", "free")));
                                
                                break;
                                
                            case 6:
                               
                                if (cursor.one().get("SeatStatus").equals("bought")){
                                    
                                    System.out.println(newFlight.getID());
                                    System.out.println(newFlight.getDestination());
                                    System.out.println(newFlight.getDate());
                                    System.out.println(newFlight.getGate());
                                    System.out.println(newFlight.getHour());
                                    System.out.println(cursor.one().get("Seat"));
                                    System.out.println(cursor.one().get("SeatStatus"));
                                    
                                } else {
                                    
                                    System.out.println("You must buy a seat before printing your boarding card");
                                    
                                }
                                
                                break;
                            case 7:
                                
                                System.out.println("Bye");
                                
                                break;
                                
                            default:

                                //If a non valid option was given
                                System.out.println("Please, choose one of the options belowGilson");
                                
                                break;
                        } 
                    }

                }
                if(menuLogin == 2){


                    System.out.println("Insert your name: ");

                    name = input.next();

                    System.out.println("Insert your cpf: ");

                    cpf = input.next();

                    System.out.println("Insert your e-mail: ");

                    email = input.next();

                    for(User i: arrayUser){

                        while(email.equals(i.getEmail())){

                            System.out.println("\nThis email is already in use! Use another");

                            email = input.next();
                        }

                    }

                    System.out.println("Insert your password: ");

                    password = input.next();

                    System.out.println("Insert your cellphone: ");

                    cellphone = input.nextLong();

                    System.out.println("Insert your credit_card: ");

                    credit_card = input.nextLong();

                    User new_user = new User(name, cpf, email, password, cellphone, credit_card);

//                    Seat assento = new EconomicClass(0);
                    
                    User userAdaptor = null;

                    collection.insert(userAdaptor.toDBObject(new_user));

                    arrayUser.add(new_user);

                    menuLogin = 100;

                }else{
                    System.out.println("Please, choose one of the choices below");

                    menuLogin = 100;
                }
            }
        
        } catch (Exception e){
        
            System.out.println(e);
        
        }
        
        System.out.println("Server is ready");
        
        
    }
}
