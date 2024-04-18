import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addition")
public class Addition extends HttpServlet {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String number1 = req.getParameter("number1");
	String number2 = req.getParameter("number2");
	int sum = Integer.parseInt(number2)+Integer.parseInt(number1);
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	writer.append("Addition of two numbers is " + sum);
	writer.close();
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String number1 = req.getParameter("number1");
	String number2 = req.getParameter("number2");
	int sum = Integer.parseInt(number2)+Integer.parseInt(number1);
	resp.setContentType("text/html");
	PrintWriter writer = resp.getWriter();
	writer.append("Addition of two numbers is " + sum);
	writer.close();
	}
}
