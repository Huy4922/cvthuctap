package Servlets;
import static Servlets.DBUtils.deleteProduct;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteProductServlet
 */
@WebServlet("/deleteProductServlet")
public class deleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException, ClassNotFoundException, SQLException{
    	   
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
        try {
        	Connection conn = MySQLConntUtils.getMySQLConnection();
			DBUtils.deleteProduct(conn, id);
			request.getRequestDispatcher("/ProductListServlet").forward(request, response);
        } catch (Exception e) {
			// TODO Auto-generated catch block
     	   e.printStackTrace();
        } 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}