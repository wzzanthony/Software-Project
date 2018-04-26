package test.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_test {
	public static Connection getConnection(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","lnashx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void insert(){
		Connection conn=getConnection();
		try {
			String sql="INSERT INTO tbl_user(name,password,email)"+"VALUES('Tom','123456','tom@gmail.com' )";
			Statement st=conn.createStatement();
			int count=st.executeUpdate(sql);
			System.out.println("向用户表中插入了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void update(){
		Connection conn=getConnection();
		try {
			String sql="UPDATE tbl_user SET email='tom@126.com' WHERE NAME='Tom'";
			Statement st=conn.createStatement();
			int count=st.executeUpdate(sql);
			System.out.println("向用户表中更新了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void delete(){
		Connection conn=getConnection();
		try {
			String sql="DELETE FROM tbl_user WHERE NAME='Tom'";
			Statement st=conn.createStatement();
			int count=st.executeUpdate(sql);
			System.out.println("向用户表中删除了"+count+"条记录");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		//insert();
		//update();
		delete();
	}
}
