package wsp.com.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import wsp.com.entity.PlayerEntity;

/**
 * mysql方法存放
 * @author WSP
 */
public class CommonMethodDao <E>{
	private PreparedStatement pre = null;
	private Connection con = null;
	private ResultSet rs = null;
	/**
	 * 表名
	 * @param tabelName
	 * 要删除的数据的标识名(账号名)
	 * @param countName
	 * 要删除的数据的标识(账号)
	 * @param count
	 * 是否成功标记
	 * @return
	 */
	public int removeOne(String tabelName, String countName, String count) {
		String sql = "delete from "+tabelName+" where "+countName+" =?;";
		int i = -1;
		con = LinkMysqlDao.getConnection();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, count);
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkMysqlDao.closeConnection(con);
		try {
			if (pre!=null) {
				pre.close();
				pre = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con!=null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 要改变的值
	 * @param myChange
	 * 要改变的变量名
	 * @param willChangeName
	 * 表名
	 * @param tabelName
	 * 标识名
	 * @param countName
	 * 标识
	 * @param count
	 * 是否成功
	 * @return
	 */
	public <T> int changeOne(T myChange, String willChangeName,String tabelName, String countName, String count) {
		String sql = "update "+tabelName+" set "+willChangeName+" = ? where "+countName+" =?;";
		int i = -1;
		con = LinkMysqlDao.getConnection();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, count);
			i = pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkMysqlDao.closeConnection(con);
		try {
			if (pre!=null) {
				pre.close();
				pre = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con!=null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	/**
	 * 对象
	 * @param object
	 * 表名
	 * @param tabelName
	 * 是否成功
	 * @return
	 */
	public int addData(Object object, String  tabelName) {
		con = LinkMysqlDao.getConnection();
		int i = -1;
		StringBuilder sql = new StringBuilder("insert into "+tabelName+" (");
        Class<? extends Object> c= object.getClass();
        String className=c.getName();
        Field[] fields =c.getDeclaredFields();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2= new StringBuilder(" )values( ");
        for (int j=0; j<fields.length;j++) {
        	System.out.println(fields[j].getName());
        	if (j>0) {
				s1.append(",");
				s2.append(",");
			}
            s1.append(fields[j].getName());
            s2.append("?");
		}
        s2.append(" );");
        sql.append(s1);
        sql.append(s2);
     try {
		pre = con.prepareStatement(sql.toString());
		System.out.println(sql.toString());
		Method[]m= c.getDeclaredMethods();
        for (Method method : m) {
            String mName=method.getName();
            //这里挑出get方法
            if(mName.startsWith("get")){
                for (int j = 0; j < fields.length; j++) {
                    if(fields[j].getName().equalsIgnoreCase(mName.substring(3))){
                    	System.out.println("1111");
                        try {
							pre.setObject(j+1, method.invoke(object));
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                }
            }
        }
        i = pre.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     LinkMysqlDao.closeConnection(con);
     try {
    	 if (pre!=null) {
			pre.close();
			pre = null;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     try {
			if (con!=null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<E> selectMassager(E eMake, LinkedList<E> linkedList, String tabelName, String count, String countName) {
		con = LinkMysqlDao.getConnection();
		String sql  = null;
		if (count.equals("all")) {
			count = "%";
			sql = "select * from"+ tabelName +" where count like %?%";;
		} else{
			sql = "select * from "+tabelName+" where "+countName+" = ? ;";
		}
		try {
			System.out.println(sql);
			pre = con.prepareStatement(sql);
			pre.setString(1, count);
			rs = pre.executeQuery();
			while(rs.next()) {
				System.out.println("llllllllll");
				Class<? extends Object> cl = eMake.getClass();
				Constructor<?> cn;
				E e = null;
				try {
					cn = cl.getConstructor();
					try {
						e = (E)cn.newInstance();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (NoSuchMethodException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SecurityException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Class<? extends Object> c= e.getClass();
				Field[] fields = c.getDeclaredFields();
				System.out.println(fields.length+"\t"+c.getName());
				for (Field field : fields) {
					field.setAccessible(true);	
					try {
						field.set(e, rs.getObject(field.getName()));
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }	
				linkedList.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
				if (rs!=null) {
			rs.close();
			rs = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (pre!=null) {
				pre.close();
				pre = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkMysqlDao.closeConnection(con);
		con = null;
		return linkedList;
	}
	
	public String getCiper(String count, String tabelName) {
		String sql = "select ciper from "+tabelName+" where count = ?;";
		String ciper = null;
		con = LinkMysqlDao.getConnection();
		try {
			pre = con.prepareStatement(sql);
			pre.setString(1, count);
			rs = pre.executeQuery();
			if (rs.next()) {
				ciper = rs.getString("ciper");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (pre!=null) {
				pre.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LinkMysqlDao.closeConnection(con);
		try {
			if (con!=null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ciper;
	}
	
	
	public static void main(String[] args) {
		PlayerEntity player = new PlayerEntity();
		player.setCan_load(false);
		player.setCiper("1111111");
		player.setCount("222222");
		player.setDay(Timestamp.valueOf("2020-05-05 20:00:00"));
		player.setName("332");
		player.setPicture_way("11");
		player.setTeam("11");
		player.setOld(11);
		LinkedList<PlayerEntity> playerEntities = new LinkedList<>();
		CommonMethodDao<PlayerEntity> c = new CommonMethodDao<PlayerEntity>();
		playerEntities = c.selectMassager(new PlayerEntity(),playerEntities, "player", "1", "id");
		System.out.println(playerEntities.getFirst().getCount());
//		playerEntities = c.selectMassager(playerEntities, "player", "222222", "count");
//		System.out.println(playerEntities.getFirst().getCiper());
	}
}
