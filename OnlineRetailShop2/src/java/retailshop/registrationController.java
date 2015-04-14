/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 *
 * @author rahat
 */
@WebServlet(name = "registrationController", urlPatterns = {"/registrationController"})
public class registrationController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String conPassword = request.getParameter("conPass");
        String type = "customer";
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        Connection conn = null;

        /* if(firstName==null || email==null || password==null || conPassword==null ||type== null){
        request.setAttribute("regMessage","Please give information correctly");
        request.getServletContext().
        getRequestDispatcher("/registrationForm.jsp").forward(request, response);  
        }*///else{
        if (password.equals(conPassword)) {

            emailValiditor aEmailValiditor = new emailValiditor();
            boolean valid = aEmailValiditor.valid(email);
            if (valid == true) {

                try {
                    DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
                    conn = ds.getConnection();
                    Statement s = conn.createStatement();
                    s.execute("insert into users (uFirstName,uLastName,uAddress,uContact,uEmail,uPassword,uType) values('" + firstName + "','" + lastName + "','" + address + "','" + contact + "','" + email + "','" + password + "','" + type + "');");
                    //response.sendRedirect("home.jsp");
                    registration aRegistretion = new registration();
                    aRegistretion.setMessage1("Registretion successfull");
                    request.setAttribute("regMessage", "Registretion successfull");
                    request.getServletContext().
                            getRequestDispatcher("/home.jsp").forward(request, response);

                } catch (Exception ex) {
                    Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);

                } finally {
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }

                //  request.getServletContext().
                //  getRequestDispatcher("/home.jsp").forward(request, response);
            } else {

                registration aRegistretion = new registration();
                request.setAttribute("regMessage", "Invalid email. Try again");
                request.getServletContext().
                        getRequestDispatcher("/registrationForm.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("regMessage", "Registretion failed. Try again");
            request.getServletContext().
                    getRequestDispatcher("/registrationForm.jsp").forward(request, response);
        }
        //}
    }

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
