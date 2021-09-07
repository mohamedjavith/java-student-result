

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ajaxprojectdbconnection.connectiondb;

/**
 * Servlet implementation class deletestudent
 */
@WebServlet("/deletestudent")
public class deletestudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("staffid")==null){
			response.sendRedirect("staff.jsp");
		}else {
		
		PrintWriter out = response.getWriter();
		try { 
			Connection con = connectiondb.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("delete from student where sid = ?");
			st.setInt(1, Integer.parseInt(request.getParameter("sid")));
			
			st.executeUpdate();
	        st.close();
	        con.close();
			response.sendRedirect("staffhomepage");
			
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		}
	}

}
