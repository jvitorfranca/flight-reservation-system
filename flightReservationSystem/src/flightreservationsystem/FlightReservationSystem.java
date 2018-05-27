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

    public static User Logado;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //inicializing Seats
        Seat[][] arraySeat = new Seat [20][6];
        
        for (int i = 0;i < 20;i++){
            
            for (int j = 0;j < 6;j++){
                
                arraySeat[i][j] = new Seat(false);
                
            }
            
        }
        //inicializing Flight1
        Flight newFlight = new Flight("010", "01", "São Paulo", "25/05/2018",arraySeat);
        
        
        
        
        
        
        
        
        ArrayList<User> arrayUser = new ArrayList();
        
        int menuLogin = 100;
        int menuOptions = 100;
        
        Scanner input = new Scanner(System.in);
        
        String name;
        String cpf;
        String email;
        String password;
        long cellphone;
        long credit_card;
        
        while(menuLogin == 100 && menuOptions <= 105){
            
            System.out.println("1- Log In");
            System.out.println("2- Sign Up");
            
            menuLogin = input.nextInt();
            
            if(menuLogin == 1){

                System.out.println("Email: ");

                String emailLogin = input.next();

                System.out.println("Password: ");

                String PasswordLogin = input.next();

                for(User i: arrayUser){
                    
                    if(emailLogin.equals(i.getEmail())){
                        
                        if(PasswordLogin.equals(i.getPassword())){
                            
                            System.out.println("Your are in!");
                            FlightReservationSystem.Logado = i;
                            
                            while(menuOptions == 100){
                                
                                menuOptions = 99;
                                
                                System.out.println("1- Consult");
                                System.out.println("2- Reservate");
                                System.out.println("3- Buy");
                                System.out.println("4- Cancel");
                                System.out.println("5- Log Out");
                                
                                menuOptions = input.nextInt();
                                
                                if(menuOptions == 1){
                                    
                                    newFlight.print();
                                }
                                if(menuOptions == 5){
                                    FlightReservationSystem.Logado = null;
                                    menuOptions = 106;
                                }
                            }
                        }else{
                            System.out.println("Incorrect Password");
                        }
                    }else{
                        System.out.println("Incorrect Email");
                    }
                }
                
                menuLogin = 100;


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
                        
                        System.out.println("This email is already in use! Use another");
                        
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
                arrayUser.add(new_user);

                menuLogin = 100;
            }
        }
        
        
    }
    
}
