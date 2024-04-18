import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/welcome2")
public class WelcomeGenericServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		writer.append("<Html>");
		writer.append("<body>");
		writer.append("<h1> Welcome With Annotation with GenericServlet</h1>");
		writer.append("</body>");
		writer.append("</html>");
		writer.close();
	}

}
