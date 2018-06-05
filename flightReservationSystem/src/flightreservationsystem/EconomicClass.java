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
public class EconomicClass extends Seat {

    public EconomicClass(int ocupied) {
        super(ocupied);
        setPrice();
    }
    
    public void setPrice(){
        
        price = 400;
        
    }
    
    public double getPrice(){
        
        return price;
        
    }
    
}
