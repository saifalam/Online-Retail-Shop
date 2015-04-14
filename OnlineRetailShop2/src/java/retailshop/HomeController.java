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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Kaiser
 */
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Connection conn = null;
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            Statement s = conn.createStatement();
            s.execute("SELECT p.pId, p.pName, c.catName, p.pSpecification,p.pImage,s.sName,pr.price FROM orcl12.product AS p, orcl12.supplier AS s, orcl12.price AS pr,orcl12.category AS c WHERE p.sid  = s.sid AND p.catId =c.catId AND p.pgid = pr.pgid AND pr.category = 'web' AND CURDATE() BETWEEN pr.date_from AND pr.date_to;");
            ResultSet rs = s.getResultSet();
            ProductInfo aProductInfo = new ProductInfo();
            while (rs.next()) {
                Product aProduct = new Product();
                aProduct.setProductId(rs.getInt("pId"));
                aProduct.setProductName(rs.getString("pName"));
                aProduct.setProductCategory(rs.getString("catName"));
                aProduct.setProductSpecification(rs.getString("pSpecification"));
                aProduct.setProductimage(rs.getString("pImage"));
                aProduct.setSupplierName(rs.getString("sName"));
                aProduct.setPrice(rs.getDouble("price"));
                aProductInfo.getProductList().add(aProduct);
            }
            request.getSession().setAttribute("aProductInfo", aProductInfo);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            Statement s = conn.createStatement();
            s.execute("SELECT catName FROM category;");
            ResultSet rs = s.getResultSet();
            Category aCategory = new Category();
            while (rs.next()) {
                aCategory.getCategoryList().add(rs.getString("catName"));
            }
            request.getSession().setAttribute("aCategory", aCategory);
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            Statement s = conn.createStatement();
            s.execute("SELECT sName FROM supplier;");
            ResultSet rs = s.getResultSet();
            Supplier aSupplier = new Supplier();
            while (rs.next()) {
                aSupplier.getSupplierList().add(rs.getString("sName"));
            }
            request.getSession().setAttribute("aSupplier", aSupplier);
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

        request.setAttribute("card", "no");
        request.getServletContext().
                getRequestDispatcher("/home.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
