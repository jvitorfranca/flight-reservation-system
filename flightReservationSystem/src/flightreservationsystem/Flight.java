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
    
    public void reservation(Seat arraySeat[][], int row, String col, User Logado){
        
        if (col.equalsIgnoreCase("A")){
            
            arraySeat[row - 1][1 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][1 - 1], row, 1);
            
        } else if (col.equalsIgnoreCase("B")){
            
            arraySeat[row - 1][2 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][2 - 1], row, 2);
            
        } else if (col.equalsIgnoreCase("C")){
            
            arraySeat[row - 1][3 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][3 - 1], row, 3);
            
        } else if (col.equalsIgnoreCase("D")){
            
            arraySeat[row - 1][4 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][4 - 1], row, 4);
            
        } else if (col.equalsIgnoreCase("E")){
            
            arraySeat[row - 1][5 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][5 - 1], row, 5);
            
        } else if (col.equalsIgnoreCase("F")){
            
            arraySeat[row - 1][6 - 1].setOcupied(1);
            
            Logado.setSeat(arraySeat[row - 1][6 - 1], row, 6);
            
        }
        
    }
    
    public void buy(Seat arraySeat[][], User Logado){
        
        arraySeat[Logado.getRow() - 1][Logado.getCol() - 1].setOcupied(2);
        
        System.out.println("Purchase successful");
        
    }
    
}
