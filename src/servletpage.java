

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import ajaxprojectdbconnection.connectiondb;
/**
 * Servlet implementation class servletpage
 */
@WebServlet("/servletpage")
public class servletpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("name"));
		  PrintWriter out = response.getWriter();
		  for(int i=1;i<11;i++) {
		  out.print("<tr><td>"+num+" x "+i+" =<td>"+num*i+"</td></tr>");
		  }
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			  
         
			 Connection con = connectiondb.initializeDatabase();
  
            
            PreparedStatement st = con
                   .prepareStatement("insert into student values(?, ?)");
  
    
            st.setInt(1, Integer.valueOf(request.getParameter("age")));
  
            
            st.setString(2, request.getParameter("name"));
  
            
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
