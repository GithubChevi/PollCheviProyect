 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DBconnection;
import DAO.Functions;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Chevi
 */

public class CreateUser_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection connect;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nif_u = request.getParameter("nif");
            String pass_u = request.getParameter("pass");
            boolean b;
            User user = new User(nif_u,pass_u,false);
            Functions f = new Functions();
            b=f.addUser(user,connect);
            if(b == true){
                //JOptionPane.showMessageDialog(null, "User created, Welcome "+nif_u+" !","Info : ",JOptionPane.INFORMATION_MESSAGE);
                HttpSession session=request.getSession(true);
                session.setAttribute("user", user);
                //response.setStatus(HttpServletResponse.SC_FOUND);
                response.sendRedirect("View/ViewVote.jsp");
            }
            else{
                HttpSession session=request.getSession(true);
                session.setAttribute("msg","Cannot create the user, NIF is in use");
                //JOptionPane.showMessageDialog(null, "Cannot create the user","Info : ",JOptionPane.INFORMATION_MESSAGE);
                //response.setStatus(HttpServletResponse.SC_FOUND);
                response.sendRedirect("index.jsp");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void init()throws ServletException{
        try{
            DBconnection con = DBconnection.getConnection();
            connect=con.getCon();
        }
        catch(ClassNotFoundException cnfe){
            
        }
        catch(SQLException sqle){
            
        }
    }
}
