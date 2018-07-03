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

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setYourSeat(Seat yourSeat) {
        this.yourSeat = yourSeat;
    }

    public void setCellphone(long cellphone) {
        this.cellphone = cellphone;
    }

    public void setCredit_card(long credit_card) {
        this.credit_card = credit_card;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
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
        
        return new BasicDBObject("Name", user.getName()).append("Cpf", user.getCpf()).append("E-mail", user.getEmail()).append("Password", user.getPassword()).append("Cellphone", user.getCellphone()).append("Credit card", user.getCredit_card()).append("Seat", "00").append("RowSeat", 0).append("ColSeat", 0).append("SeatStatus", "free");
        
    }
    
}
