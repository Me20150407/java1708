package yuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Demo3 {
	private static Logger logger=Logger.getLogger(Demo3.class.getName());
	public static void main(String[] args) {
		
		//1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		
		//2、建立连接
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "texttt", "1234");
		} catch (SQLException e) {
			logger.error(e);
		}
		//3、插入狗狗信息到数据库
		
		Statement stmt=null;
		String  name="欧欧";
		int health=100;
		int love=0;
		String strain="酷酷的雪纳瑞";
		try {
			stmt=conn.createStatement();
			StringBuffer sbsql=new StringBuffer("insert into dog (name,health,love,strain) values ('");
			sbsql.append(name+"',");
			sbsql.append(health+",");
			sbsql.append(love+",'");
			sbsql.append(strain+"')");
			stmt.execute(sbsql.toString());
			System.out.println("111");
			logger.info("插入狗狗信息成功!");
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			try {
				if (stmt!=null) {
					stmt.close();
				}
				if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
		
	
	}
}
