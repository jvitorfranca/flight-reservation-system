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
public class User {
    
    private String name;
    private String cpf;
    private String email;
    private String password;
    private long cellphone;
    private long credit_card;
     
    User(String name, String cpf, String email, String password, long cellphone, long credit_card){
        
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.cellphone = cellphone;
        this.credit_card = credit_card;
        
    }
    
    private void Reservate(Flight newFlight){
        
        //Access the selected Flight
        //Show the seats
        //Check the Class of the Passenger and limitates its access to the array
        //Let the Passenger select a seat to be ocupied
        
        
    }
    
}
