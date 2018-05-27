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

    Seat(int ocupied){
    
        this.ocupied = ocupied;
    
    }
    
    private int ocupied;
    
    public void setOcupied(int ocupied){
       
        this.ocupied = ocupied;
    
    }
    
    public int getOcupied(){
    
        return this.ocupied;
    
    }
        
}
