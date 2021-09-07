

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dummychecking
 */
@WebServlet("/dummychecking")
public class dummychecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dummychecking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 PrintWriter out = response.getWriter();
	 int count=0;
	 for(int i=1;i<=100;i++) {
	 int rand1 = (int) (Math.random()*100000);
	 for(int j=1; j<=100;j++) {
		 int rand2 = (int) (Math.random()*100000);
		 out.print(rand1+"---"+rand2);
		 if(rand1 == rand2) {
			 out.print("--111111111");
			 count++;
		 }
		 out.print("\n");
	 }
	 }
	 out.print("matches "+count);
	}

	

}
