package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		request.setCharacterEncoding("utf-8");
    		 response.setCharacterEncoding("utf-8");
    		response.getWriter().append("Served at:").append(request.getContextPath());
    		 String txt = request.getParameter("txtSearch");
            List<Product> list=new ArrayList<Product>();
    		try {
    		Connection conn = MySQLConntUtils.getMySQLConnection();
    		list = DBUtils.Search(conn,txt);
    		} catch (SQLException e) {
    		e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    			request.setAttribute("productList",list);
    			request.getRequestDispatcher("/Productlist.jsp").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
