/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rahat
 */
@WebServlet(name = "myAccountController", urlPatterns = {"/myAccountController"})
public class myAccountController extends HttpServlet {

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

        Login aLogin = null;
        LoginInfo aLoginInfo = null;
        if (session != null) {
            Object loginObj = session.getAttribute("aLogin");
            Object loginInfoObj = session.getAttribute("aLoginInfo");

            if ((loginObj != null && loginObj instanceof Login) && (loginInfoObj != null && loginInfoObj instanceof LoginInfo)) {

                aLogin = (Login) loginObj;
                aLoginInfo = (LoginInfo) loginInfoObj;
                session.setAttribute("myAccount", "Wel come to your shopping account");
                response.sendRedirect("myAccountView.jsp");
                return;
            }
            session.setAttribute("myAccount", "Please Login to see your details");
            session.setAttribute("aLogin", null);
            session.setAttribute("aLoginInfo", null);
            response.sendRedirect("myAccountView.jsp");
            return;
        }

        session.setAttribute("aLogin", null);
        session.setAttribute("aLoginInfo", null);
        session.setAttribute("myAccount", "Please Login to see your details");
        response.sendRedirect("myAccountView.jsp");
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
