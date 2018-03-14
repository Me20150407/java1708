package yuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Demo4 {
	private static Logger logger=Logger.getLogger(Demo4.class.getName());
	public static void main(String[] args) {
		//1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2、建立连接
		Connection conn=null;
		 Statement stat=null;
		 try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "texttt", "1234");
			//3、更新狗狗信息到数据库
			stat=conn.createStatement();
			stat.executeUpdate("update dog set health=90,love=15 where id=1");
			logger.info("成功更新狗狗信息！");
		} catch (SQLException e) {
			logger.error(e);
		}finally {
			try {
				if (stat!=null) {
					stat.close();
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
