package wsp.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsp.com.control.CommonControl;
/**
 * 登陆窗口业务处理 
 * @author WSP
 */
public class LoadServlet extends HttpServlet{
	
	CommonControl commonControl = new CommonControl();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("aaaaaaaaaaaaaaaa");
		String check = arg0.getMethod();
		if (check.equals("GET")) {
			doGet(arg0, arg1);
		} else if (check.equals("POST")) {
			doPost(arg0, arg1);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String count = req.getParameter("username");
		String ciper = req.getParameter("password");
		String who = req.getParameter("who");
		if (commonControl.canLoad(count, ciper, who)) {
			
		} else {
			resp.getWriter().write("window.alert('错误')");
		}
	}
}
