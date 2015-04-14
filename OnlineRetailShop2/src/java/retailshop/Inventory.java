/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

/**
 *
 * @author rahat
 */
public class Inventory {

    private int id;
    private String quantity;

    public Inventory() {
        id = 0;
        quantity = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
