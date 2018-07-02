/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author vitorfranca
 */
public class User {
    
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Seat yourSeat;
    private long cellphone;
    private long credit_card;
    private int row;
    private int col;
     
    User(String name, String cpf, String email, String password, long cellphone, long credit_card){
        
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.credit_card = credit_card;
        row = -1;
        col = -1;
        
    }
    
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public Seat getYourSeat() {
        return yourSeat;
    }

    public long getCellphone() {
        return cellphone;
    }

    public long getCredit_card() {
        return credit_card;
    }
    
    private void Reservate(Flight newFlight){
        
        //Access the selected Flight
        //Show the seats
        //Check the Class of the Passenger and limitates its access to the array
        //Let the Passenger select a seat to be ocupied
        
        
    }
    
    public void setSeat(Seat seat, int row, int col){
        
        this.yourSeat = seat;
        
        this.row = row;
        
        this.col = col;
        
    }
    
    public void printSeat(){ 
        
        System.out.println("Seat: " + row  + " " + col);
        
    }
    
    public Seat getSeat(){
        
        return this.yourSeat;
        
    }
    
    public int getRow(){
  
        return this.row;
        
    }
    
    public int getCol(){
  
        return this.col;
        
    }
    
    public double getPrice(){
        
        double result = 0;
        return result;
    }
    
    public static DBObject toDBObject(User user){
        
        return new BasicDBObject("Name", user.getName()).append("Cpf", user.getCpf()).append("E-mail", user.getEmail()).append("Password", user.getPassword()).append("Cellphone", user.getCellphone()).append("Credit card", user.getCredit_card());
        
    }
    
}
