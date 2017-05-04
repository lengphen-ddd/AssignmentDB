
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        if(con != null){
            System.out.println("connecte success....");
        }else {
            System.err.println("connection false...");
        }
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
            System.out.println("Insert failse!...");
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

    public static boolean deleteProduct(int id){
        boolean b = false; 
        Connection con = getMyconnection();
        String sql = "delete * from product where p_id = ? ";
        try {
            //new
            PreparedStatement pr = con.prepareStatement(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(db.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static void main(String agr[]){
//        db.getMyconnection();
        Product p = new Product(1, "ss", 40);
//        db.insertProduct(p);
          db.updateProduct(p);
        
    }
    
    
}
