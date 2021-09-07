

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.*;



/**
 * Servlet implementation class jsondemo
 */
@WebServlet("/jsondemo")
public class jsondemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONObject person1 = new JSONObject();
		person1.put("name", "javith");
		person1.put("age", "22");
		JSONObject person2 = new JSONObject();
		person2.put("name", "Rohith");
		person2.put("age", "21");
		JSONObject person3 = new JSONObject();
		person3.put("name", "Karthi");
		person3.put("age", "21");
		JSONArray person = new JSONArray();
		person.add(person1);
		person.add(person2);
		person.add(person3);
		PrintWriter out = response.getWriter();
		out.write(person.toString());
		
		
		
	
	}


}
