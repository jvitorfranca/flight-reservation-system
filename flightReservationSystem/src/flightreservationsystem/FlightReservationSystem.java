/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightreservationsystem;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author vitorfranca
 */
public class FlightReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        String name;
        String cpf;
        String email;
        String password;
        long cellphone;
        long credit_card;
        
        System.out.println("Insert your name: ");
        
        name = input.next();
        
        System.out.println("Insert your cpf: ");
        
        cpf = input.next();
 
        System.out.println("Insert your e-mail: ");
        
        email = input.next();
        
        System.out.println("Insert your password: ");
        
        password = input.next();
        
        System.out.println("Insert your cellphone: ");
        
        cellphone = input.nextLong();
        
        System.out.println("Insert your credit_card: ");
        
        credit_card = input.nextLong();
        
        User new_user = new User(name, cpf, email, password, cellphone, credit_card);
        
        Seat[][] arraySeat = new Seat [20][6];
        
        for (int i = 0;i < 20;i++){
            
            for (int j = 0;j < 6;j++){
                
                arraySeat[i][j] = new Seat(false);
                
                
              
            }
            
        }
        
        ArrayList<User> arrayUser = new ArrayList();
        
        arrayUser.add(new_user);
        
        Flight newFlight = new Flight("010", "01", "São Paulo", "25/05/2018",arraySeat);
        
        newFlight.print();
        
    }
    
}
