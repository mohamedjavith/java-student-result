

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.result;



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
			
			 int mark = Integer.valueOf(request.getParameter("mark"));
            int sid = Integer.valueOf(request.getParameter("studentidresult"));
            String subcode = request.getParameter("subjectcode");
            
			/* call model */
            result rs = new result();
            String msg = rs.addresult(sid, subcode, mark);
            
           PrintWriter out = response.getWriter();
           out.write(msg);
	}

}
