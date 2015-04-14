/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

//import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaiser
 */
public class ProductDetailList {

    private List<ProductDetail> productList;

    public ProductDetailList() {
        productList = new ArrayList<ProductDetail>();
    }

    /**
     * @return the productList
     */
    public List<ProductDetail> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(List<ProductDetail> productList) {
        this.productList = productList;
    }
}
