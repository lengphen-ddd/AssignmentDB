
package module;

import java.io.Serializable;


public class Product implements Serializable{
    private int id;
    private String p_name;
    private int p_qty;

    public Product(){}
    
    public Product(int id, String p_name, int p_qty) {
        this.id = id;
        this.p_name = p_name;
        this.p_qty = p_qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_qty() {
        return p_qty;
    }

    public void setP_qty(int p_qty) {
        this.p_qty = p_qty;
    }
    
    
    
}
