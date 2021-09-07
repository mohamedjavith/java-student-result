

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.student;

import java.util.Random;




@WebServlet("/addstudent")
public class addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("staff.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	
			Random rand = new Random(); 
			int sid = rand.nextInt((9999 - 100) + 1) + 10; 
			String name = request.getParameter("studentname");
			String passname = name.replaceAll("\\s", "");
			passname = passname.toLowerCase();
			String password = passname+"123";
			String city = request.getParameter("studentcity");
			String dept = request.getParameter("studentdept");
			 
			student addstud = new student();
			String result = addstud.addstudent(sid, passname, city, dept, password);
     
           PrintWriter out = response.getWriter();
           out.write(result);
           
      
	}

}
