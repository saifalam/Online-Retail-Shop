/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.catalina.Session;

/**
 *
 * @author Kaiser
 */
@WebServlet(name = "PurchaseController", urlPatterns = {"/PurchaseController"})
public class PurchaseController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stock = 0;
        int quantity = 0;
        int id = 0;
        HttpSession session = request.getSession();
        Transaction aTransaction = null;
        Object ob1 = session.getAttribute("aTransaction");
        if (ob1 != null && ob1 instanceof Transaction) {
            aTransaction = (Transaction) ob1;
        }
        TransactionList aTransactionList = null;
        Object ob = session.getAttribute("aTransactionList");
        if (ob != null && ob instanceof TransactionList) {
            aTransactionList = (TransactionList) ob;
        }
        Connection conn = null;
        try {

            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("INSERT into transactions (pId,pName,quantity,price,uId,sell_date)values(?,?,?,?,?,?)");
            for (Transaction tr : aTransactionList.getTransactionList()) {
                id = tr.getProductId();
                ps.setInt(1, tr.getProductId());
                ps.setString(2, tr.getProductName());
                quantity = tr.getQuantity();
                ps.setInt(3, tr.getQuantity());
                ps.setDouble(4, tr.getPrice());
                ps.setInt(5, tr.getuId());
                ps.setString(6, tr.getSellDate());
                ps.executeUpdate();
            }

            session.setAttribute("aTransactionList", aTransactionList);
        } catch (Exception ex) {
            Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("SELECT * FROM inventory WHERE pId=?;");
            ps.setInt(1, id);
            ResultSet rs = null;
            rs = ps.executeQuery();
            while (rs.next()) {
                stock = rs.getInt("quantity");
            }
        } catch (Exception ex) {
            Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("UPDATE inventory SET quantity = ? WHERE pId= ?;");
            ps.setInt(1, (stock - quantity));
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PurchaseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        session.setAttribute("success", "Purchase complete. Soon you will get your product.");
        response.sendRedirect("transactionView.jsp");

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
