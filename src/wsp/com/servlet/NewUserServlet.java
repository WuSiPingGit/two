package wsp.com.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

import wsp.com.bean.SetNewPlayerBean;
import wsp.com.control.PlayerControl;
import wsp.com.entity.PlayerEntity;
import wsp.com.util.IoUtil;
import wsp.com.util.SendMailUtil;

public class NewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PlayerControl playerControl= new PlayerControl();
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		if (arg0.getMethod().equals("POST")) {
			doPost(arg0, arg1);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = null;
		try {
			list = upload.parseRequest(req);
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String count = null;
		String ciper =  null;
		String name =  null;
		String team =  null;
		String date =  null;
		String old =  null;
		String readme = null;
		PlayerEntity player =  null;
		Map<String, String> map = new HashMap<String,String>();
		String path = "D://javac//playersView//WebContent//UserPicture//";
		InputStream inputStream = null;
		for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {
				String key = fileItem.getFieldName();
				 String value = fileItem.getString();
				 System.out.println(key+"\t"+value);
				 map.put(key, value);
			} else {
				inputStream = fileItem.getInputStream();
			}
		}
		count = map.get("count");
		ciper =  map.get("ciper");
		name =  map.get("name");
		team =  map.get("team");
		date =  map.get("date");
		old =  map.get("old");
		readme = map.get("readme");
		path +=count+".jpg";
		System.out.println(count+ciper+name);
		IoUtil.save(inputStream, path);
		String clickmail;
		try {
			clickmail = SendMailUtil.SendQQMail(count);
			player = SetNewPlayerBean.setPlayerEntity(count, ciper, name, team, date, path, Integer.parseInt(old), readme, clickmail);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (playerControl.hasIt(count)) {
			if (playerControl.newPlayer(player)) {
				req.getRequestDispatcher("relifemail.jsp").forward(req, resp);
			} else {
				resp.setContentType("text/html;charset=utf-8");
				resp.addHeader("refresh", "3;url=load.jsp");
				resp.getWriter().write("未知错误，可能已经存在账号、请登录；或再次注册");
			}
		} else {
			resp.setContentType("text/html;charset=utf-8");
			resp.addHeader("refresh", "3;url=load.jsp");
			resp.getWriter().write("用户已存在，3秒后会自动登陆界面，请登陆");
		}
	}
}
