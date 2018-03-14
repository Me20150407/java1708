package yuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Demo2 {
	private static Logger logger=Logger.getLogger(Demo2.class.getName());
	public static void main(String[] args) {
		Connection conn=null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		//2、建立连接
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/text","texttt","1234");
			System.out.println("建立连接成功！");
			logger.info("建立连接成功！");
		} catch (SQLException e) {
			logger.error(e);
		}finally {
			try {
				if (conn!=null) {
					conn.close();
					System.out.println("关闭连接成功!");
				}
			} catch (SQLException e) {
				logger.error(e);
			}
		}
				
	}
}
