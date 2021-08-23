import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ajaxprojectdbconnection.connectiondb;

/**
 * Servlet implementation class staffhomepage
 */
@WebServlet("/staffhomepage")
public class staffhomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("staff.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try { 
			Connection con = connectiondb.initializeDatabase();
			/* Statement stmt = con.createStatement(); */
			PreparedStatement st = con.prepareStatement("select * from staff where staffid=? and password=?");
			
			st.setInt(1, Integer.valueOf(request.getParameter("staffid")));
			st.setString(2, request.getParameter("password")); 
			ResultSet rs = st.executeQuery();
			 if(rs.next()) 
             { 
				 int id =  rs.getInt("staffid"); 
				 String name =  rs.getString("name"); 
				 String dept =  rs.getString("dept"); 
				 
				 request.setAttribute("name", name);
				 request.setAttribute("id", id);
				 request.setAttribute("dept", dept);
					
				RequestDispatcher rd = request.getRequestDispatcher("staffhome.jsp");
				rd.forward(request, response);
					 
             }else {
            	 out.println("404");
            	 request.setAttribute("error", "404");
            	 RequestDispatcher rd = request.getRequestDispatcher("staffhome.jsp");
				 rd.forward(request, response);
             }
		}
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
