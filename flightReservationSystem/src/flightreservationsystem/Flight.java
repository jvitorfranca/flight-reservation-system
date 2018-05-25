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
public class Flight {
    
    private String ID;
    private String gate;
    private String destination;
    private String date;
    private Seat arraySeat[][] = new Seat [20][6];  
    
    Flight(String ID, String gate, String destination, String date, Seat arraySeat[][]){
        
        this.ID = ID;
        this.gate = gate;
        this.destination = destination;
        this.date = date;
        this.arraySeat = arraySeat;
        
    }
    
    
    public void print(){
        
        for(int i = 0;i< arraySeat.length;i++){
            
            for(Seat j : arraySeat[i]){
                
                if(j.getOcupied()){
                    
                    System.out.print("1");
                
                }else{
                    
                    System.out.print("0");
                
                }
            }
            
            System.out.println();
            
        }
    
    }
    
}
