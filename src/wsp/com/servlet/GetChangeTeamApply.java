package wsp.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetChangeTeamApply
 */
public class GetChangeTeamApply extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	if (arg0.getMethod().equals("GET")) {
			doGet(arg0, arg1);
		}
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
}
