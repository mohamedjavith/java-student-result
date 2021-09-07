

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;



/**
 * Servlet implementation class editstudent
 */
@WebServlet("/editstudent")
public class editstudent extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
			
			
			String name = request.getParameter("name");
			String city = request.getParameter("city");
			String dept = request.getParameter("dept");
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			student editstudent = new student();
			String msg = editstudent.editstudent(sid, name, city, dept);
			
			out.print(msg);
			
		
	}

}
