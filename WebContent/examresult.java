

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ajaxprojectdbconnection.connectiondb;

/**
 * Servlet implementation class examresult
 */
@WebServlet("/examresult")
public class examresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try { 
			Connection con = connectiondb.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("select * from results where sid=?");
			
			st.setInt(1, Integer.valueOf(request.getParameter("sid")));
			
			ResultSet rs = st.executeQuery();
			out.println("<tr><td><b>Subject Code</b><td><b>Mark</b><td><b>Result</b></td></tr>");
			 while(rs.next()) 
             { 
				 
				 String subjectcode =  rs.getString("subjectcode");
				 int mark =  rs.getInt("mark"); 
				 String result =  rs.getString("result"); 
				
				 out.println("<tr><td>"+subjectcode+"<td>"+mark+"<td>"+result+"</td></tr>");
				 
				
            
             }
		}
        catch (Exception e) {
            e.printStackTrace();
        }
	}

}
