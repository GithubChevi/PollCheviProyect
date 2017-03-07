package Controller;



import DAO.DBconnection;
import DAO.Functions;
import Model.Anime;
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
public class Vote_servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occursvb
     * 
     * 
     */
    
    private Connection connect;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            boolean b;
            
            HttpSession session=request.getSession(true);
            User user = (User)session.getAttribute("user");
            
            String nif = user.getNif();
            
            String name_a=request.getParameter("anime_list");
            //JOptionPane.showMessageDialog(null, name_a,"Info : ",JOptionPane.INFORMATION_MESSAGE);
            
            Anime anime = new Anime(name_a);
            Functions f=new Functions();
            
            b=f.vote(user, anime,connect);
            out.println("<h1>Vote_servlet</h1>");
            if(b == true){
               session.invalidate();
               response.setStatus(HttpServletResponse.SC_FOUND);
               response.sendRedirect("View/ViewEnd.jsp");
            }
            else{
               session.invalidate();
               response.setStatus(HttpServletResponse.SC_FOUND);
               response.sendRedirect("View/ViewErrorEnd.jsp");
               
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
