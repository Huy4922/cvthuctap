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
 * Servlet implementation class SearchNV
 */
@WebServlet("/SearchNV")
public class SearchNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNV() {
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
            List<NhanVien> list=new ArrayList<NhanVien>();
    		try {
    		Connection conn = MySQLConntUtils.getMySQLConnection();
    		list = DBUtils.SearchNV(conn,txt);
    		} catch (SQLException e) {
    		e.printStackTrace();
    		} catch (ClassNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		}
    			request.setAttribute("nhanvienList",list);
    			request.getRequestDispatcher("/Nhanvienlist.jsp").forward(request, response);
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
