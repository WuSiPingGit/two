package wsp.com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;
/**
 * mysql连接池
 * @author WSP
 */
public class LinkMysqlDao {
	private static int maxLink = 50;
	private static int minLink = 30;
	private static int extend = 4;
	private static int count;
	private static Connection conn;
	private static Properties p = new Properties();
	private static String driver;
	private static String host;
	private static String user;
	private static String ciper;
	private static LinkedList<Connection> linkedList = new LinkedList<Connection>();
	/**
	 * 建立connection
	 */
	private synchronized static boolean createConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(host,user,ciper);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn!=null) {
				try {
					conn.close();
					System.exit(0);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		return conn!=null;
	}
	/**
	 *建立mysql连接
	 */
	private static synchronized void createLinkList() {
		for(int i=0;i<minLink;i++) {
			if (createConnection()) {
				linkedList.add(conn);
				count++;
				conn = null;
			}
		}
	}
	
	/**
	 * 增加连接
	 */
	private static synchronized void extendLinkList() {
		if (count>=maxLink) {
			return;
		}
		for(int i=0;i<extend;i++) {
			if (count==maxLink) {
								System.out.println(count);
				break;
			} else {
				if (createConnection()) {
					linkedList.add(conn);
					conn = null;
					System.out.println(i);
					count ++;
				}
			}
		}
	}
	/**
     * 减少连接
     */
	private static synchronized void reduceLink() {
		while(count>minLink) {
			try {
				linkedList.removeLast().close();
				count --;
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	} 
	/**
	 * 获取连接
	 */
	public static synchronized Connection getConnection() {
		if (count>0) {
			count--;
			return linkedList.removeFirst();
		} else {
			extendLinkList();
			if (count>0) {
				count--;
				return linkedList.removeFirst();
			}
			else
				return null;
		}
	}
	/**
	 *放回连接
	 * @param connection
	 */
	public static synchronized void closeConnection(Connection connection) {
		if (count<maxLink&&connection!=null) {
			count++;
			linkedList.add(connection);
		} else {
			reduceLink();
		}	
	}
	/**
	 * 初始化
	 */
	static {
		try {
			p.load(new FileInputStream("D:/javac/playersView/src/collectionsql.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	driver = p.getProperty("driver");
	host = p.getProperty("host");
	user = p.getProperty("user");
	ciper = p.getProperty("ciper");
	createLinkList();
	}
}
