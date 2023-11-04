package Servlets;
import static Servlets.DBUtils.insertUserAccount;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignInServlet"})
public class SignInServlet extends HttpServlet {
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	    Connection conn = null;
	    try {
	        conn = MySQLConntUtils.getMySQLConnection();

	        String username=request.getParameter("username");
	        String gender=request.getParameter("gender");
	        String password=request.getParameter("password");

	        UserAccount usr=new UserAccount(username, gender,password);

	        DBUtils.insertUserAccount(conn, usr);

	        
	        response.sendRedirect(request.getContextPath() + "/Success.jsp");

	    } catch (ClassNotFoundException ex) {
	        Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
	    } catch (SQLException ex) {
	        Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	        if(conn != null){
	            try {
	                conn.close();
	            } catch (SQLException ex) {
	                Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	}

 
}
 
 
