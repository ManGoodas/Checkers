/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkers;

import java.util.Scanner;

/**[
 *
 * @author Mantas Gudynas
 */

public class Checkers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int map[][] = new int[][] {
            {1,99,1,99,1,99,1,99},
            {99,1,99,1,99,1,99,1},
            {1,99,1,99,1,99,1,99},
            {99,0,99,0,99,0,99,0},
            {0,99,0,99,0,99,0,99},
            {99,2,99,2,99,2,99,2},
            {2,99,2,99,2,99,2,99},
            {99,2,99,2,99,2,99,2},
        };
        boolean ejimas = false;
        boolean error = false;
        boolean vyksta = true;
        Scanner scanner = new Scanner(System.in);
        
        while(vyksta){
        try{
            outer:   
          for (int i = 0;i<=7;i++){
            for(int j = 0;j<=7;j++){
               if (map[i][j] == 0) {
                   System.out.print("(E)");
               }
               else if (map[i][j] == 1) {
                   System.out.print("<R>");
               }
               else if (map[i][j] == 2) {
                   System.out.print("<J>");
               }
               else if (map[i][j] == 99){
                   System.out.print("XXX");
               }
               else if (map[i][j] == 10){
                   System.out.print("<1>");
               }
               else if (map[i][j] == 20){
                   System.out.print("<2>");
               }
            }
            System.out.print('\n');
            }
                    
            if (ejimas == false) {
                System.out.print("1 zaidejo eile(R).\n");
            } else {
                System.out.print("2 zaidejo eile(J).\n");
            }
            if (error == true) {
                System.out.print("Ivyko klaida, iveskite is naujo tinkama judesi.");
            }
            System.out.print("is kur is kur ir i kur noresite judeti(pvz: 54 55):\n");
            String k = scanner.nextLine();
            String[] dalys = k.split(" ");
            boolean isNumeric1 = dalys[0].chars().allMatch( Character::isDigit ); 
            boolean isNumeric2 = dalys[1].chars().allMatch( Character::isDigit );  
            
            if ((dalys.length == 2) && (isNumeric1 == true) && (isNumeric2 == true) && (dalys[0].length() == 2) && (dalys[1].length() == 2)){
              int pirmopirmas = dalys[0].charAt(0)-'0';
              int pirmoantras = dalys[0].charAt(1)-'0';
              int antropirmas = dalys[1].charAt(0)-'0';
              int antroantras = dalys[1].charAt(1)-'0';
              //System.out.print(pirmopirmas + " " + pirmoantras + " " + antropirmas + " " + antroantras + " " );
              if ((pirmopirmas > 0) && (pirmopirmas <9) && (pirmoantras > 0) && (pirmoantras <9) && (antropirmas > 0) && (antropirmas <9) && (antroantras > 0) && (antroantras <9)) {
                if ((ejimas == false)) {

                   if (map[pirmopirmas-1][pirmoantras-1] == 1) {
                      if ((pirmopirmas == antropirmas-1) && ((pirmoantras == antroantras+1) || (pirmoantras == antroantras-1))) {
                        if ((map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = true;
                         map[antropirmas-1][antroantras-1] = 1;
                         map[pirmopirmas-1][pirmoantras-1] = 0;
                         error = false;
                        }
                        error = false;
                      }
                      else if ((pirmopirmas == antropirmas-2) && ((pirmoantras == antroantras-2) || (pirmoantras == antroantras) || (pirmoantras == antroantras+2))){
                        if (((map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 2) || (map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 20)) && (map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = true;
                         map[antropirmas-1][antroantras-1] = 1;
                         map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] = 0;
                         map[pirmopirmas-1][pirmoantras-1] = 0; 
                         error = false;
                        }
                        else error = true;
                      }
                      else error = true;
                   }
                   else if (map[pirmopirmas-1][pirmoantras-1] == 20) {
                      if (((pirmopirmas == antropirmas+1) || (pirmopirmas == antropirmas-1)) && ((pirmoantras == antroantras+1) || (pirmoantras == antroantras-1))) {
                        if ((map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 10;
                         map[pirmopirmas-1][pirmoantras-1] = 0;
                         error = false;
                         }
                        else error = true;  
                      }
                      else if (((pirmopirmas == antropirmas+2) || (pirmopirmas == antropirmas-2)) && ((pirmoantras == antroantras-2) || (pirmoantras == antroantras) || (pirmoantras == antroantras+2))){
                        if (((map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 2) || (map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 20)) && (map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 10;
                         map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] = 0;
                         map[pirmopirmas-1][pirmoantras-1] = 0;   
                         error = false;
                        }
                        else error = true;
                      } 
                       
                   }
                } 
                else {
                   if (map[pirmopirmas-1][pirmoantras-1] == 2) {
                      if ((pirmopirmas == antropirmas+1) && ((pirmoantras == antroantras+1) || (pirmoantras == antroantras-1))) {
                        if ((map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 2;
                         map[pirmopirmas-1][pirmoantras-1] = 0;
                         error = false;
                         }
                        else error = true;
                      }
                    else if ((pirmopirmas == antropirmas+2) && ((pirmoantras == antroantras-2) || (pirmoantras == antroantras) || (pirmoantras == antroantras+2))){
                        if (((map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 1) || (map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 10)) && (map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 2;
                         map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] = 0;
                         map[pirmopirmas-1][pirmoantras-1] = 0;   
                         error = false;
                        }
                        else error = true;
                    }
                    else error = true;
                   }
                   else if (map[pirmopirmas-1][pirmoantras-1] == 20) {
                      if (((pirmopirmas == antropirmas+1) || (pirmopirmas == antropirmas-1)) && ((pirmoantras == antroantras+1) || (pirmoantras == antroantras-1))) {
                        if ((map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 20;
                         map[pirmopirmas-1][pirmoantras-1] = 0;
                         error = false;
                         }
                        else error = true;  
                      }
                      else if (((pirmopirmas == antropirmas+2) || (pirmopirmas == antropirmas-2)) && ((pirmoantras == antroantras-2) || (pirmoantras == antroantras) || (pirmoantras == antroantras+2))){
                        if (((map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 1) || (map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] == 10)) && (map[antropirmas-1][antroantras-1] == 0)) {
                         ejimas = false;
                         map[antropirmas-1][antroantras-1] = 20;
                         map[((antropirmas+pirmopirmas)/2)-1][((antroantras+pirmoantras)/2)-1] = 0;
                         map[pirmopirmas-1][pirmoantras-1] = 0;   
                         error = false;
                        }
                        else error = true;
                      }
                   }
                }
              }
              else error = true;
            }
            else {
              error = true;  
            }
        //todo : if goes to end make king
        for (int i = 0;i<=7;i++){
            if (map[0][i] == 2){
                map[0][i] = 20;
            }
            if (map[7][i] == 1){
                map[7][i] = 10;
            }
            
        }
          
        
        
        //todo : check if someone won;
        int raud = 0;
        int juod = 0;
        for (int i = 0;i<=7;i++){
            for(int j = 0;j<=7;j++){
                if ((map[i][j] == 10) || (map[i][j] == 1)) {
                   raud = raud +1; 
                    
                }
                else if ((map[i][j] == 20) || (map[i][j] == 2))
                    juod = juod +1;
            }
        }
        if (raud == 0) {
           System.out.print("2 ZAIDEJAS LAIMEJO\n");
           System.out.print("GAMEOVER\n");
        }
        else if (juod == 0) {
           System.out.print("1 ZAIDEJAS LAIMEJO\n");
           System.out.print("GAMEOVER\n");
        }
        
        
        }    
        catch(Exception e){
           System.out.println("Ivyko klaida");}    
        
        }
    }
       
    
}
