

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;



/**
 * Servlet implementation class liststudentdetails
 */
@WebServlet("/liststudentdetails")
public class liststudentdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	
		out.println("<tr><th>Student Id</th><th>Name</th><th>Department</th><th>City</th><th>Action</th></tr>");
		student liststud = new student();
		out.print(liststud.ListStudent());
	}

}
