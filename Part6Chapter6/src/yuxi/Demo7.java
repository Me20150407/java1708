package yuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class Demo7 {
	private static Logger logger = Logger.getLogger(Demo4.class.getName());

	public static void main(String[] args) {
		// 1、加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		// 2、建立连接
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "texttt", "1234");
			// 3、更新狗狗信息到数据库
			String sql = "update dog set health=?,love=?,name=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 80);
			pstmt.setInt(2, 90);
			pstmt.setString(3, "稀稀2");
			pstmt.setInt(4, 1);
			pstmt.executeUpdate();
			
			pstmt.setInt(1, 90);
			pstmt.setInt(2, 15);
			pstmt.setInt(3, 2);
			pstmt.setString(4, "稀稀");
			pstmt.executeUpdate();
			logger.info("成功更新狗狗信息!");

		} catch (SQLException e) {
			logger.error(e);
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				logger.error(e);
			}
		}
	}

}
