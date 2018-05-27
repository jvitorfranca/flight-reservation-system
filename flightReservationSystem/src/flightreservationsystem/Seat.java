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

    Seat(boolean ocupied){
    
        this.ocupied = ocupied;
    
    }
    
    private boolean ocupied;
    
    public void setOcupied(Boolean ocupied){
       
        this.ocupied = ocupied;
    
    }
    
    public boolean getOcupied(){
    
        return this.ocupied;
    
    }
        
}
