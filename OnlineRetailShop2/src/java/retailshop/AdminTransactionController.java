/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
 * @author rahat
 */
@WebServlet(name = "AdminTransactionController", urlPatterns = {"/AdminTransactionController"})
public class AdminTransactionController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        // Login aLogin = null;
        // Object ob1 = session.getAttribute("aLogin");

        // if (ob1 != null && ob1 instanceof Login) {


        Connection conn = null;
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            Statement s = conn.createStatement();
            s.executeQuery("SELECT t.tId, t.pId,t.pName, t.quantity,t.price,t.uId,t.sell_date,u.uFirstName,u.uLastName, u.uContact,u.uEmail, u.uAddress FROM onlineretailshop.transactions AS t, onlineretailshop.users AS u WHERE t.uId = u.uId;");
            ResultSet rs = s.getResultSet();

            AdminTransactionList aAdminTransactionList = new AdminTransactionList();
            while (rs.next()) {
                AdminTransaction aAdminTransaction = new AdminTransaction();
                aAdminTransaction.setTransactionId(rs.getInt("tId"));
                aAdminTransaction.setProductId(rs.getInt("pId"));
                aAdminTransaction.setProductName(rs.getString("pName"));
                aAdminTransaction.setQuantity(rs.getInt("quantity"));
                aAdminTransaction.setPrice(rs.getDouble("price"));
                aAdminTransaction.setuId(rs.getInt("uId"));
                aAdminTransaction.setSellDate(rs.getString("sell_date"));
                aAdminTransaction.setFirstName(rs.getString("uFirstName"));
                aAdminTransaction.setLastName(rs.getString("uLastName"));
                aAdminTransaction.setContact(rs.getString("uContact"));
                aAdminTransaction.setEmail(rs.getString("uEmail"));
                aAdminTransaction.setAddress(rs.getString("uAddress"));

                aAdminTransactionList.getAdminTransactionList().add(aAdminTransaction);
            }
            session.setAttribute("aAdminTransactionList", aAdminTransactionList);
            session.setAttribute("adminMessage", " Transaction analysis:");
            session.setAttribute("home", null);
            response.sendRedirect("adminTransactionView.jsp");
            return;

        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }


        /*       session.setAttribute("adminMessage","this is a reserved page for admin.");
        session.setAttribute("home","go to home..");
        response.sendRedirect("adminTransactionView.jsp");
        return;
        }*/
        session.setAttribute("adminMessage", "this is a reserved page for admin.");
        session.setAttribute("home", "go to home");
        response.sendRedirect("adminTransactionView.jsp");
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
