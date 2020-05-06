package wsp.com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsp.com.control.PlayerControl;


public class RelifeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PlayerControl playerControl = new PlayerControl();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		if (arg0.getMethod().equals("POST")) {
			doPost(arg0, arg1);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String count = req.getParameter("count");
		String check = req.getParameter("clickmail");
		if (playerControl.relife(count, check)) {
			resp.setContentType("text/html;charset=utf-8");
			resp.addHeader("refresh", "3;url=load.jsp");
			resp.getWriter().write("以激活，3秒后会自动回退登陆界面，管理员认证后课登陆");
		} else {
			resp.setContentType("text/html;charset=utf-8");
			resp.addHeader("refresh", "3;url=relifemail.jsp");
			resp.getWriter().write("错误！请重新输入；3秒后会自动回退");
		}
	}
}
