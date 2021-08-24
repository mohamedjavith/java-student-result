

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import ajaxprojectdbconnection.connectiondb;

/**
 * Servlet implementation class addstudent
 */
@WebServlet("/addstudent")
public class addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("staff.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			Random rand = new Random(); 
			int sid = rand.nextInt(9999); 
			String name = request.getParameter("studentname");
			String passname = name.replaceAll("\\s", "");
			passname = passname.toLowerCase();
			String password = passname+"123";
			
			 Connection con = connectiondb.initializeDatabase();
 
           
           PreparedStatement st = con
                  .prepareStatement("insert into student values(?, ?, ?, ?, ?)");
 
   
           st.setInt(1, sid);
           st.setString(2,name);
           st.setString(3, request.getParameter("studentcity"));
           st.setString(4, request.getParameter("studentdept"));
           st.setString(5,password);
           
           st.executeUpdate();
 
          
           st.close();
           con.close();
           PrintWriter out = response.getWriter();
           out.write("Successfully Inserted");
           
       }
       catch (Exception e) {
           e.printStackTrace();
       }
	}

}
