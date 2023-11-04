package Servlets;

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

/**
 * Servlet implementation class logServlet
 */
@WebServlet("/logServlet")
public class logServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = MySQLConntUtils.getMySQLConnection();
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			UserAccount usr=new UserAccount(username,password);
			
			
			UserAccount u=DBUtils.findUser(conn,usr.getUserName(),usr.getPassword());
			
			if(u != null)
			{
				UserAccount user=new UserAccount(u);
				request.setAttribute("username", "Xin chào: " +user.getUserName());				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else
			{
				response.setContentType("text/html;charset=UTF-8");
				try (PrintWriter out = response.getWriter()){
					 
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("<title>Thong bao<title>");
					out.println("</head>");
					out.println("<body>");
					out.println("<h1>thong tin khong chinh xac <a href=LogIn.jsp>Nhap lai</a></h1>");
					out.println("</body>");
					out.println("</html>");					
				}
			}
		} catch (ClassNotFoundException ex) {
			
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE,null, ex);
		} catch (SQLException ex) {
			Logger.getLogger(SignInServlet.class.getName()).log(Level.SEVERE,null, ex);
		}
	}

}
