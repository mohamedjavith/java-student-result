import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.staff;


@WebServlet("/staffhomepage")
public class staffhomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		staff staff1 = new staff();
		int staffid;
		String password;
		ArrayList<staff> staffdetail = new ArrayList<staff>();
			if(session.getAttribute("staffid")== null && session.getAttribute("staffkey")==null) {
				staffid = Integer.parseInt(request.getParameter("staffid"));
				password = request.getParameter("password");
				staffdetail = staff1.staffdetail(staffid,password);
			}else {
				staffid = Integer.parseInt(session.getAttribute("staffid").toString());
				password = session.getAttribute("staffkey").toString(); 
				staffdetail = staff1.staffdetail(staffid,password);
			}
			
				
				 
				 if(session.getAttribute("staffid")==null) {
					 session.setAttribute("staffid", staffid);
					 session.setAttribute("staffkey", password);
					}
				 
				 request.setAttribute("staffdetail", staffdetail);
				 
					
				RequestDispatcher rd = request.getRequestDispatcher("staffhome.jsp");
				rd.forward(request, response);
					 
           
		
	}

}
