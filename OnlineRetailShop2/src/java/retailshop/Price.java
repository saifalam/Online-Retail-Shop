/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

/**
 *
 * @author Kaiser
 */
public class Price {

    public double totalPrice(Double unitPrice, String quantity) {
        Double i = Double.valueOf(quantity);
        return unitPrice * i;

    }
}
