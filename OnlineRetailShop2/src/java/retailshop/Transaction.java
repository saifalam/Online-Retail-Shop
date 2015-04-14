/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.util.Date;

/**
 *
 * @author Kaiser
 */
public class Transaction {

    private int transactionId;
    private int productId;
    private String productName;
    private int quantity;
    private double price;
    private int uId;
    private String sellDate;

    /**
     * @return the transactionId
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the uId
     */
    public int getuId() {
        return uId;
    }

    /**
     * @param uId the uId to set
     */
    public void setuId(int cId) {
        this.uId = cId;
    }

    /**
     * @return the sellDate
     */
    public String getSellDate() {
        return sellDate;
    }

    /**
     * @param sellDate the sellDate to set
     */
    public void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }
}
