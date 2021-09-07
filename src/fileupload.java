

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/fileupload")
@MultipartConfig
public class fileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Part part = request.getPart("image");
			String filename = part.getSubmittedFileName();
			part.write("/home/diligent/eclipse-workspace/ajaxproject/WebContent/"+filename);
			
			PrintWriter out = response.getWriter();
			out.println(request.getParameter("name"));
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
