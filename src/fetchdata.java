

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.model.student;




@WebServlet("/fetchdata")
public class fetchdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		HttpSession session = request.getSession();
		student st1 = new student();
		int sid;
		String password;
		ArrayList<student> studentdetail = new ArrayList<student>();
			if(session.getAttribute("sid")== null && session.getAttribute("key")==null) {
				sid = Integer.parseInt(request.getParameter("sid"));
				password = request.getParameter("key");
				studentdetail = st1.studentdetail(sid,password);
			}else {
				sid = Integer.parseInt(session.getAttribute("sid").toString());
				password = session.getAttribute("key").toString(); 
				studentdetail = st1.studentdetail(sid,password);
			}
			
				
				 
				 if(session.getAttribute("sid")==null) {
					 session.setAttribute("sid", sid);
					 session.setAttribute("key", password);
					}
				 request.setAttribute("studentdetail", studentdetail);	
				RequestDispatcher rd = request.getRequestDispatcher("studentResult.jsp");
				rd.forward(request, response);
					 
            
		
	}

}
