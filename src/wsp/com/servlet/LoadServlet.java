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
		System.out.println(count+"\t"+ciper+"\t"+who);
		if (who!=null&&commonControl.canLoad(count, ciper, who)) {
			if (who.equals("管理员")) {
				req.getRequestDispatcher("/playersView/WebContent/WEB-INF/manager.jsp").forward(req, resp);
			} else if (who.equals("职业选手")) {
				req.getRequestDispatcher("/WEB-INF/player.jsp").forward(req, resp);
			} else {
				req.getRequestDispatcher("/playersView/WebContent/WEB-INF/teammassager.jsp").forward(req, resp);
			}
		} else {
			resp.setContentType("text/html;charset=utf-8");
			resp.addHeader("refresh", "3;url=load.jsp");
			resp.getWriter().write("输入账号或密码或用户类型错误，3秒后会自动回退");
		}
	}
}
