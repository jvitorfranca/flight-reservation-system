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
                
                if(i<= 5){
                    
                    arraySeat[i][j] = new FirstClass(0);
  
                }else{
                        
                    arraySeat[i][j] = new EconomicClass(0);
                        
                }
                
                
            }
            
        }
        //inicializing Flight1
        Flight newFlight = new Flight("010", "01", "São Paulo", "25/05/2018",arraySeat);
        
        ArrayList<Flight> arrayFlight = new ArrayList();

        arrayFlight.add(newFlight);
        
        ArrayList<User> arrayUser = new ArrayList();
        
        int menuLogin = 100;
        int menuOptions = 100;
        
        int row;
        
        Scanner input = new Scanner(System.in);
        
        String col;
        
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
                            
                            menuOptions = 100;
                            
                            while(menuOptions == 100){
                                
                                menuOptions = 99;
                                
                                System.out.println("1- Consult");
                                System.out.println("2- Reservate");
                                System.out.println("3- Buy");
                                System.out.println("4- Realocate");
                                System.out.println("5- Cancel");
                                System.out.println("6- Log Out");
                                
                                menuOptions = input.nextInt();
                                
                                if(menuOptions == 1){
                                    
                                    newFlight.seatMap();
                                    
                                    menuOptions = 100;
                                    
                                } else if(menuOptions == 2){
                                    
                                    if (Logado.getSeat() == null){
                                        
                                        newFlight.seatMap();

                                        System.out.println("Insert the row of your seat. Ex: 20 ");

                                        row = input.nextInt();

                                        System.out.println("Insert the collumn of your seat. Ex: C ");

                                        col = input.next();

                                        newFlight.reservation(arraySeat, row, col, FlightReservationSystem.Logado);

                                        newFlight.seatMap();

                                        Logado.getSeat(); 
                                        
                                    } else {
                                        
                                        System.out.println("Sorry, but you can reserve just one seat");
                                        
                                    }

                                    menuOptions = 100;
                                    
                                } else if(menuOptions == 3){
                                    
                                    if (Logado.getSeat() != null){
                                        
                                        newFlight.buy(arraySeat, Logado);   
                                        
                                    } else {
                                        
                                        System.out.println("You must reserve first");
                                        
                                    }
                                    
                                    menuOptions = 100;
                                    
                                } else if(menuOptions == 4){
                                    
                                    System.out.println("Insert the row of your new seat. Ex: 20 ");

                                    row = input.nextInt();

                                    System.out.println("Insert the collumn of new your seat. Ex: C ");

                                    col = input.next();
                                    
                                    if (Logado.getSeat().getOcupied() == 1){
                                        
                                        newFlight.realocateReservation(arraySeat, Logado, row, col);
                                        
                                    } else if (Logado.getSeat().getOcupied() == 2){
                                        
                                        newFlight.realocatePurchase(arraySeat, Logado, row, col);
                                        
                                    }
                                     
                                    menuOptions = 100;
                                    
                                } else if(menuOptions == 5){
                                    
                                    newFlight.cancel(arraySeat, Logado);
                                    
                                    menuOptions = 100;
                                    
                                } else if(menuOptions == 6){
                                    
                                    FlightReservationSystem.Logado = null;
                                    
                                    menuOptions = 90;
                                    
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
                
                Seat assento = new EconomicClass(0);
                
                arrayUser.add(new_user);

                menuLogin = 100;
                
            }
        }
    }
}
