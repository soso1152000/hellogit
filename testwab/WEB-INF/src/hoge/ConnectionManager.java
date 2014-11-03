package hoge;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionManager {
	//JDBCのドライバのクラス
	final static String DRIVER = "com.mysql.jdbc.Driver";
	//DBのURL
	final static String URL = "jdbc:mysql://localhost/mydb";
	//ユーザー
	final static String USER  =  "root";
	//パスワード
	final static String PASS = "hoge";
	//connecection
	public static Connection getConnection()throws SQLException {

		try{
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
			throw new IllegalStateException(
				"fail to class load :"
				+ e.getMessage());
		}

		Connection con = DriverManager.getConnection(URL,USER,PASS);
		return con;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException{
		// TODO 自動生成されたメソッド・スタブ
		Connection con = getConnection();
		Statement smt = con.createStatement();
		ResultSet rs = smt.executeQuery("select * from account");
		while(rs.next()){
			String s = "NAME=" + rs.getString("NAME") + ",MONEY=" + rs.getString("MONEY") ;
			System.out.println(s);
		}
		smt.close();
		con.close();
		System.out.println("end");
	}

}
