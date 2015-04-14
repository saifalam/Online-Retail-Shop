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
import javax.sql.DataSource;

/**
 *
 * @author Kaiser
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = null;
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("datasource");
            conn = ds.getConnection();
            PreparedStatement ps = null;
            ps = conn.prepareStatement("SELECT p.pId, p.pName, c.catName, p.pSpecification,p.pImage,s.sName,pr.price FROM onlineretailshop.product AS p, onlineretailshop.supplier AS s, onlineretailshop.price AS pr,onlineretailshop.category AS c WHERE c.catName=? AND p.sid  = s.sid AND p.catId =c.catId AND p.pgid = pr.pgid AND pr.category = 'web' AND CURDATE() BETWEEN pr.date_from AND pr.date_to;");
            String category = request.getParameter("category");
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            CategoryShow aCategoryShow = new CategoryShow();
            aCategoryShow.getCategoryShowList().clear();
            while (rs.next()) {
                CategoryList aCategoryList = new CategoryList();
                aCategoryList.setProductId(rs.getInt("pId"));
                aCategoryList.setProductName(rs.getString("pName"));
                aCategoryList.setProductCategory(rs.getString("catName"));
                aCategoryList.setProductSpecification(rs.getString("pSpecification"));
                aCategoryList.setProductImage(rs.getString("pImage"));
                aCategoryList.setSupplierName(rs.getString("sName"));
                aCategoryList.setPrice(rs.getDouble("price"));
                aCategoryShow.getCategoryShowList().add(aCategoryList);
                System.out.println(aCategoryShow.getCategoryShowList());
            }
            request.getSession().setAttribute("aCategoryShow", aCategoryShow);
        } catch (Exception ex) {
            Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        request.getServletContext().
                getRequestDispatcher("/showByCategory.jsp").forward(request, response);
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
