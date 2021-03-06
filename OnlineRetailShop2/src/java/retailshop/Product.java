/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

/**
 *
 * @author Kaiser
 */
public class Product {

    private int productId;
    private String productName;
    private String productCategory;
    private String productSpecification;
    private String productimage;
    private String supplierName;
    private double price;

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
     * @return the productCategory
     */
    public String getProductCategory() {
        return productCategory;
    }

    /**
     * @param productCategory the productCategory to set
     */
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    /**
     * @return the productSpecification
     */
    public String getProductSpecification() {
        return productSpecification;
    }

    /**
     * @param productSpecification the productSpecification to set
     */
    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    /**
     * @return the productimage
     */
    public String getProductimage() {
        return productimage;
    }

    /**
     * @param productimage the productimage to set
     */
    public void setProductimage(String productimage) {
        this.productimage = productimage;
    }

    /**
     * @return the sId
     */
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
     * @return the sName
     */
    public String getSupplierName() {
        return supplierName;
    }

    /**
     * @param sName the sName to set
     */
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
