package yuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class Demo5 {
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
		ResultSet rs=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/text", "texttt", "1234");
			//3、查询并输入狗狗信息
			stat=conn.createStatement();
			rs=stat.executeQuery("SELECT id,name,health,love,strain FROM dog");
			System.out.println("\t\t狗狗信息表");
			System.out.println("编号\t姓名\t健康值\t亲密度\t品种");
			while (rs.next()) {
				System.out.print(rs.getInt(1)+"\t");
				System.out.print(rs.getString(2)+"\t");
				System.out.print(rs.getInt("health")+"\t");
				System.out.print(rs.getInt("love")+"\t");
				System.out.println(rs.getString("strain"));
			}
		} catch (SQLException e) {
			logger.error(e);
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
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
