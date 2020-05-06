package wsp.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;	
import wsp.com.control.PlayerControl;
public class PlayerMassagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    PlayerControl playerControl = new PlayerControl();
    @Override  
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	if (arg0.getMethod().equals("GET")) {
			doGet(arg0, arg1);
		} else {
			doPost(arg0, arg1);
		}
    }
      
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    }
     
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	doPost(req, resp);
    }
}
