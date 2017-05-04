
package validation;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author leng phen
 */
public class validate {
    
    public static void hr(){
        System.out.println("\n-----------------------------------------------\n");
    }
    
    public static void error(){
        System.err.println("Your enter not correct. please check again!");
    }
    
    public static void error(String error){
        System.err.println(error);
    }
    
    
    public static int getNum(int ch,String msg){	
        int ok=-1;
            do{
                try{
                    Scanner scan=new Scanner(System.in);
//                    System.out.print(""+msg+"(1-"+ch+"):>> ");
                    System.out.print(msg);
                    ok=scan.nextInt(); 
                }catch(InputMismatchException e){       
                    ok=-1;
                }
                if(ok<1 || ok>ch){
                    System.err.println("Not correct....");
                }
            }while(ok<1||ok>ch);
            return ok;
    }
    
    public static String getInputString(String msg){
        String s = null;
        try {
            System.out.print(msg);
            Scanner myscan = new Scanner(System.in);
            s = myscan.nextLine();
        }catch(Exception e) {
            e.getMessage();
        }
        return s;
    }
    
    public static int confirm(int ch){	
        int ok=-1;
        do{
            try{
                Scanner scan=new Scanner(System.in);
                System.out.print("Press 1 for confirm or press 0 for cancel :>> ");
                ok=scan.nextInt();
            }catch(InputMismatchException e){
                ok=-1;
            }			
        }while(ok<0 ||ok>ch);
        return ok;
    }
    
 
}
