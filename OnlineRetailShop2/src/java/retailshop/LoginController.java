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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author rahat
 */
@WebServlet(name = "loginController", urlPatterns = {"/loginController"})
public class LoginController extends HttpServlet {
    // private String name= "kaiser";
    // private  String password = "123456";
    private static final Logger logger = Logger.getLogger(Login.class.getName());

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
        Login aLogin = null;
        Object ob = session.getAttribute("aLogin");
        if (ob != null && ob instanceof Login) {
            aLogin = (Login) ob;
        } else {
            aLogin = new Login();
            session.setAttribute("aLogin", aLogin);
        }
        if (aLogin.getEmail() != null && aLogin.getPassword() != null) {
            if (aLogin.getFirstName().equals("admin") && aLogin.getPassword().equals("admin")) {

                session.setAttribute("message", "already logged in.");
                session.setAttribute("warning", null);
                response.sendRedirect("adminHome.jsp");
                return;
            }
            session.setAttribute("message", "already logged in.");
            session.setAttribute("warning", null);
            response.sendRedirect("home.jsp");
            return;
        }
        Connection conn = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email != null && password != null) {

           /* try {
                DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
                conn = ds.getConnection();
                Statement s = conn.createStatement();
                s.execute("select * from users where uEmail='" + email + "' and uPassword='" + password + "';");
                ResultSet rs = s.getResultSet();
                LoginInfo aLoginInfo = new LoginInfo();

                while (rs.next()) {
                    aLogin = new Login();
                    aLogin.setUid(rs.getInt("uId"));
                    aLogin.setFirstName(rs.getString("uFirstName"));
                    aLogin.setLastName(rs.getString("uLastName"));
                    aLogin.setContact(rs.getString("uContact"));
                    aLogin.setAddress(rs.getString("uAddress"));
                    aLogin.setType(rs.getString("uType"));
                    aLogin.setEmail(rs.getString("uEmail"));
                    aLogin.setPassword(rs.getString("uPassword"));
                    if (aLogin.getPassword().equals(password) && aLogin.getEmail().equals(email)) {
                        aLoginInfo.getLoginList().add(aLogin);
                        if (aLogin.getFirstName().equals("admin") && aLogin.getPassword().equals("admin")) {
                            session.setAttribute("message", "Welcome");
                            session.setAttribute("warning", null);
                            session.setAttribute("aLogin", aLogin);
                            session.setAttribute("aLoginInfo", aLoginInfo);
                            session.setAttribute("logoutMessage", "logout");
                            response.sendRedirect("adminHome.jsp");
                            return;
                        }
                        session.setAttribute("message", "Welcome");
                        session.setAttribute("warning", null);
                        session.setAttribute("aLogin", aLogin);
                        session.setAttribute("aLoginInfo", aLoginInfo);
                        session.setAttribute("logoutMessage", "logout");
                        response.sendRedirect("home.jsp");
                        return;
                    }
                    session.setAttribute("message", "login please..");
                    session.setAttribute("warning", null);
                    response.sendRedirect("home.jsp");
                    return;

                }

            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }*/
           LoginInfo aLoginInfo = new LoginInfo();
           aLogin = new Login();
           aLogin.setFirstName("kaiser");
           aLogin.setPassword("1234");
           if (aLogin.getPassword().equals(password) && aLogin.getFirstName().equals(email)) {
                        aLoginInfo.getLoginList().add(aLogin);
                        if (aLogin.getFirstName().equals("kaiser") && aLogin.getPassword().equals("1234")) {
                            session.setAttribute("message", "Welcome");
                            session.setAttribute("warning", null);
                            session.setAttribute("aLogin", aLogin);
                            session.setAttribute("aLoginInfo", aLoginInfo);
                            session.setAttribute("logoutMessage", "logout");
                            response.sendRedirect("adminHome.jsp");
                            return;
                        }
           
            
        }

        // request.getServletContext().
        // getRequestDispatcher("/home.jsp").forward(request, response);
        session.setAttribute("message", "Yet not login.login first..");
        session.setAttribute("loginMessage", "Incorrect Email or Password. Try Again");
        session.setAttribute("warning", null);
        response.sendRedirect("home.jsp");
        return;

     }
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
