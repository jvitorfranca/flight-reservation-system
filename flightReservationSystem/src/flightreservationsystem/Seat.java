/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

/**
 *
 * @author vitorfranca
 */
public class Seat{
    
    
    private int ocupied;
    protected double price;
    
    Seat(int ocupied){
    
        this.ocupied = ocupied;
        price = 0;
        
    }

    public double getPrice() {
        
        return price;
    
    }

    public void setPrice(double price) {
        
        this.price = price;
    
    }
    
    public void setOcupied(int ocupied){
       
        this.ocupied = ocupied;
    
    }
    
    public int getOcupied(){
    
        return this.ocupied;
    
    }
        
}
