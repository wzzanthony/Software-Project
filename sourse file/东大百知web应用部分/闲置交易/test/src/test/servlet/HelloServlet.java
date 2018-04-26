package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init without parameters");
		super.init();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init without parameters");
		super.init(config);
	}
	@Override
	protected void service(HttpServletRequest reg, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("service");
		PrintWriter pw=resp.getWriter();
		pw.print("Hello World");
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		super.destroy();
	}

	

}
