/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Kaiser
 */
@WebServlet(name = "TransactionController", urlPatterns = {"/TransactionController"})
public class TransactionController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Login aLogin = null;
        Object ob1 = session.getAttribute("aLogin");
        if (ob1 != null && ob1 instanceof Login) {
            aLogin = (Login) ob1;
        }
        ProductDetailList aProductDetailList = null;
        Object ob = session.getAttribute("aProductDetailList");
        if (ob != null && ob instanceof ProductDetailList) {
            aProductDetailList = (ProductDetailList) ob;
        }
        ProductDetail aProductDetail = null;
        Object ob2 = session.getAttribute("aProductDetail");
        if (ob2 != null && ob2 instanceof ProductDetail) {
            aProductDetail = (ProductDetail) ob2;
        }
        String q = request.getParameter("quantity");
        int quantity = Integer.parseInt(q);
        int id = aProductDetail.getProductId();
        Connection conn = null;
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            PreparedStatement pt = null;
            pt = conn.prepareStatement("SELECT * FROM inventory WHERE pId=?;");
            pt.setInt(1, id);
            ResultSet rs = null;
            rs = pt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("quantity") >= quantity) {
                    Transaction aTransaction = new Transaction();
                    for (ProductDetail pD : aProductDetailList.getProductList()) {
                        aTransaction.setProductId(pD.getProductId());
                        aTransaction.setProductName(pD.getProductName());
                        aTransaction.setQuantity(quantity);
                        aTransaction.setPrice(quantity * pD.getPrice());
                        aTransaction.setuId(aLogin.getUid());
                        aTransaction.setSellDate(dateFormat.format(date));
                    }
                    TransactionList aTransactionList = new TransactionList();
                    aTransactionList.getTransactionList().add(aTransaction);
                    session.setAttribute("aTransactionList", aTransactionList);
                    response.sendRedirect("transactionView.jsp");
                    return;
                } else {
                    session.setAttribute("stock", " Insufficient Stock ");
                    response.sendRedirect("buyView.jsp");
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(TransactionController.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*finally {            
        out.close();
        }*/
        /*  request.getServletContext().
        getRequestDispatcher("/transactionView.jsp").forward(request, response);*/
        // session.setAttribute("stock", " Fill up quantity.");
        response.sendRedirect("buyView.jsp");
        return;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
