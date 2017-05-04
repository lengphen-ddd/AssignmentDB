
package assignmentdb;

import java.util.Scanner;
import module.Product;
import validation.validate;
import MyDB.db;

/**
 *
 * @author ERROR
 */
public class AssignmentDB {
    public static void menu(){
        System.out.println("  1)Insert |  2)Delete | 3)Update | 4)Display | 5)Exit");
    }
    
//    public static String getInput(String msg){
//        String s="";
//        try{
//            Scanner scan = new Scanner(System.in);
//            System.out.println(msg);
//            s = scan.toString();
//        }catch(Exception e){
//            e.getMessage();
//        }
//        return s;
//    }
//    
    public static void main(String[] args) {
        db.display();
        do{
            AssignmentDB.menu();
            
            int n = validation.validate.getNum(5, "Option >> ");
            switch(n){
                case 1: // insert
                    System.out.println("-------------------Insert---------------------");
                    int id = validation.validate.getNum(200,"ID Product >>"); 
                    String name = validation.validate.getInputString("Name >>");
                    int q = validation.validate.getNum(200,"Qty >>"); 
                    Product p = new Product(id,name,q);
                    MyDB.db.insertProduct(p);
                    System.out.println("----------------insert success-----------------");
                    db.display();
                    break;
                case 2:// delete
                    System.err.println("----------------Delete record-----------------");
                    int SId = validation.validate.getNum(1000, "Input ID >>");
                    boolean getStatus = db.search(SId);
                    if(getStatus == true) {
                        int num = validation.validate.confirm(1);
                        if(num == 1){
                            db.deleteProduct(SId);
                        }
                    }else System.err.println("The record not found...");
                    db.display();
                    break;
                case 3: // upadate
                    int SearchId = validation.validate.getNum(1000, "Input ID >>");
                    boolean state = db.search(SearchId);
                    if(state == true){
                        String updateName = validation.validate.getInputString("Name >>");
                        int updateQty = validation.validate.getNum(200,"Qty >>"); 
                        Product pro = new Product(SearchId,updateName,updateQty);
                        db.updateProduct(pro);
                    }else System.err.println("No this record...");
                    db.display();
                    break;
                case 4: 
                    db.display();
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
            if(n == 1){
          
                
            }
           
            
        }while(true);
        
        
        
    }
    
}
