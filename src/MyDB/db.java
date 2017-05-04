
package MyDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import module.Product;


public class db {
    public static Connection getMyconnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/hrd";
            String user = "postgres";
            String password = "as";
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
//        if(con != null){
//            System.out.println("connecte success....");
//        }else {
//            System.err.println("connection false...");
//        }
        return con;  
    }
    
    public static boolean insertProduct(Product p){
        boolean b=false;
        Connection con = null;
        try {
            con = getMyconnection();
            String sql ="insert into product values(?,?,?)";
            PreparedStatement pst= con.prepareStatement(sql);
            pst.setInt(1, p.getId());
            pst.setString(2,p.getP_name());
            pst.setInt(3, p.getP_qty());
            pst.executeUpdate();
            if(con != null){
                b=true;
            }
        } catch (SQLException ex) {
            System.err.println("Insert failse!...");
        }
        return b;
    }
    
    public static boolean updateProduct(Product p){
        boolean b = false;
        Connection con = getMyconnection();
        String update = "update product set p_name = ?, p_qty = ? where p_id =? ";
        try {
            PreparedStatement pr = con.prepareStatement(update);
            pr.setString(1,p.getP_name());
            pr.setInt(2,p.getP_qty());
            pr.setInt(3,p.getId());
            pr.executeUpdate();
            if(con != null) b = true;
        } catch (SQLException ex) {
            System.err.println("Update error....");
        }
        
        return b;
    }

    public static void deleteProduct(int id){
        Connection con = getMyconnection();
        String sql = "delete from product where p_id =?";
//        String sql = "delete  from product ";
        try {
          
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, id);
            pr.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("delete error...");
        }
       
    }
    
    public static boolean search(int id){
        boolean b = false;
        Connection con = getMyconnection();
        String sql = "select * from product where p_id = "+id+" ";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                 b = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static void display(){
        List<String> so = new ArrayList<String>();
        Connection con = getMyconnection();
        String sql = "select * from product";
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            so.add("|-----------------------|-----------------------|------------------");
            so.add("|\tProduct ID \t|\t Product Name \t|\t Qty");
            so.add("|-----------------------|-----------------------|------------------");
            while(rs.next()){
                 so.add("|\t"+rs.getInt(1) +"\t\t|\t" + rs.getString(2) + "\t\t|\t" + rs.getInt(3));
                 so.add("|-----------------------|-----------------------|------------------");
            }
            
            for(String s:so){
                System.out.println(s);
                Thread.sleep(60);
            }
            
        } catch (SQLException ex) {
            System.err.println("Display error...");
        } catch (InterruptedException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main(String agr[]){
        long st,et, total;
        
//        db.display();
        
        
//        boolean b = db.search(2);
//        if(b==true){
//            db.deleteProduct(2);
//        }
//        
        
        
//        db.getMyconnection();
//        Product p = new Product(2, "aaaaaaaaaa", 40);
//        db.insertProduct(p);
//          db.updateProduct(p);
//            db.deleteProduct(1);
//            st= System.currentTimeMillis();
            
//            List<Product> p = new ArrayList<Product>();

//
//            for(int i = 0 ; i<10; i++){
//                Product pro = new Product(i,"No Name",0);
//                db.insertProduct(pro);
//            }


//            et = System.currentTimeMillis();
//            total = (et-st)/1000;
//            System.out.println(total);
        
    }
    
    
}
