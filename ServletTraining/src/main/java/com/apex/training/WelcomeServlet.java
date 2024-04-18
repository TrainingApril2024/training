package com.apex.training;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class WelcomeServlet extends GenericServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Method Init()");
		super.init();
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.append("<Html>");
		writer.append("<body>");
		writer.append("<h1> Welcome 1</h1>");
		writer.append("</body>");
		writer.append("</html>");
		writer.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("Method destory()");
		super.destroy();
	}

}
