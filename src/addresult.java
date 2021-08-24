

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
 * Servlet implementation class addresult
 */
@WebServlet("/addresult")
public class addresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("staff.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			 int mark = Integer.valueOf(request.getParameter("mark"));
			 Connection con = connectiondb.initializeDatabase();
 
           
           PreparedStatement st = con
                  .prepareStatement("insert into results values(?, ?, ?, ?)");
 
   
           st.setInt(1, Integer.valueOf(request.getParameter("studentidresult")));
           st.setString(2, request.getParameter("subjectcode"));
           st.setInt(3, mark);
            if(mark < 40) {
            	st.setString(4, "RA");
            }else {
            	st.setString(4, "PASS");
            }
           
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
