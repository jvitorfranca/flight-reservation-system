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
    private String hour;
    private Seat arraySeat[][] = new Seat [20][6];  
    
    Flight(String ID, String gate, String destination, String date, String hour, Seat arraySeat[][]){
        
        this.ID = ID;
        this.gate = gate;
        this.destination = destination;
        this.date = date;
        this.hour = hour;
        this.arraySeat = arraySeat;
        
    }
    
    
    public void seatMap(){
        
        for(int i = 0;i< arraySeat.length;i++){
            
            //Imprime o indice da fileira
            if(i >= 9){
                
                System.out.printf("%d ",i+1);
                
            }else{
                
                System.out.printf("%d  ",i+1);
                
            }
            
            for(int j = 0;j < arraySeat[i].length;j++){
                
                //imprime o espaço entre o meio das fileiras
                if(j == 3){
                    System.out.print(" ");
                }
                
                //Imprime 0 se livre e 1 se ocupado
                System.out.print(arraySeat[i][j].getOcupied());
            }
            
            System.out.println();
            System.out.println();
            
        }
    
    }
    
    public Seat reservation(Seat arraySeat[][], int row, String col, User Logado){
                
        
        if (col.equalsIgnoreCase("A")){
            
            if(arraySeat[row - 1][1 - 1].getOcupied() == 0){
                arraySeat[row - 1][1 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][1 - 1], row, 1);
                
                return arraySeat[row - 1][1 - 1];
                
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
        } else if (col.equalsIgnoreCase("B")){
            
            if(arraySeat[row - 1][2 - 1].getOcupied() == 0){
                
                arraySeat[row - 1][2 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][2 - 1], row, 2);
                
                
                return arraySeat[row - 1][2 - 1];
                
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
        } else if (col.equalsIgnoreCase("C")){
            
            if(arraySeat[row - 1][3 - 1].getOcupied() == 0){
            
                arraySeat[row - 1][3 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][3 - 1], row, 3);
                
                return arraySeat[row - 1][3 - 1];
                
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
        } else if (col.equalsIgnoreCase("D")){
            
            if(arraySeat[row - 1][4 - 1].getOcupied() == 0){
            
                arraySeat[row - 1][4 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][4 - 1], row, 4);
                
                return arraySeat[row - 1][4 - 1];
                
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
        } else if (col.equalsIgnoreCase("E")){
            
            if(arraySeat[row - 1][5 - 1].getOcupied() == 0){
            
                arraySeat[row - 1][5 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][5 - 1], row, 5);
                
                return arraySeat[row - 1][5 - 1];
            
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
            
        } else if (col.equalsIgnoreCase("F")){
            
            if(arraySeat[row - 1][6 - 1].getOcupied() == 0){
            
                arraySeat[row - 1][6 - 1].setOcupied(1);

                Logado.setSeat(arraySeat[row - 1][6 - 1], row, 6);
                
                return arraySeat[row - 1][6 - 1];
            
            }else{
                
                System.out.println("This seat is already reserved");
                
            }
            
        }
        
        return null;
        
    }
    
    public void buy(Seat arraySeat[][], User Logado){
        
        if(arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].getOcupied() != 2){
        
            arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].setOcupied(2);
        
        }
        
        System.out.println("Purchase successful");
        
    }
    
    public Seat realocateReservation(Seat arraySeat[][], User Logado, int row, String col){
       
       Seat seat; 
        
       arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].setOcupied(0);
        
       Logado.setSeat(null, -1, -1); 
        
       seat = reservation(arraySeat, row, col, Logado);
     
       return seat;
       
    }
    
    public Seat realocatePurchase(Seat arraySeat[][], User Logado, int row, String col){
        
       Seat oldSeat = Logado.getSeat();
       
       Seat reserved = reservation(arraySeat, row, col, Logado);
       
       if(reserved != null){
           
           if(reserved.getOcupied() != 2){
               
                //arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].setOcupied(0);
                
                oldSeat.setOcupied(0);
                
                buy(arraySeat,Logado);
                
                return reserved;
                
           }
           
       }else{
           
           System.out.println("Something went wrong!");
           
       }
       
       return null;
       
    }
    
    public void cancel(Seat arraySeat[][], User Logado){
        
        
            if(Logado.getCol() > -1 && Logado.getRow() > -1){
                arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].setOcupied(0);

                Logado.setSeat(null, -1, -1);

                System.out.println("Cancelation successful");
            }else{
                
                System.out.println("Cancelation Fail");
                
            }
    }
    
    public void printFlight(){
        
        System.out.printf("%s - %s\n", this.destination, this.hour);
        
    }
    
    public Seat[][] getArraySeat(){
        
        return this.arraySeat;
        
    }
    
    public void printBoardingCard(User Logado){
        
        String status = "Free";
        String ColString = "";
        if(Logado.getSeat() != null){
            
            if(Logado.getSeat().getOcupied() == 1){
                
                status = "Reserved";
                
            }else if( Logado.getSeat().getOcupied() == 2){
                
                status = "Bought";
                
            }
            
            if (Logado.getCol() == 1){
                
                ColString = "A";
            
            } else if (Logado.getCol() == 2){
                
                ColString = "B";

            } else if (Logado.getCol() == 3){
                
                ColString = "C";

            } else if (Logado.getCol() == 4){
                
                ColString = "D";

            } else if (Logado.getCol() == 5){
                
                ColString = "E";

            } else if (Logado.getCol() == 6){
                
                ColString = "F";

            }
            
            
            
            
            System.out.println("||ID: " + this.ID + "|| Destination: " + this.destination +"\n\n|| Date:" + this.date +"|| Gate:" + this.gate +"|| Hour:" + this.hour+
                    "\n\n|| Seat: " + Logado.getRow()+ ColString + "|| Status: "+ status );
        }else{
            
            System.out.println("Something went wrong");
        }
        
    }
    
}
