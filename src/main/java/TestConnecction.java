import java.sql.*;
import java.util.Properties;


public class TestConnecction {
	
	public static Connection connect() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Properties propertie = new Properties();
		
		propertie.load(TestConnecction.class.getClassLoader().getResourceAsStream("db.properties"));
		
		/**System.out.println("DB URL: " + propertie.getProperty("db.url"));
		System.out.println("DB User: " + propertie.getProperty("db.user"));
		System.out.println("DB Password: " + propertie.getProperty("db.password"));
		*/
		
		String url = propertie.getProperty("db.url");
		String user =propertie.getProperty("db.user");
		String password =propertie.getProperty("db.password");
		
		if (url == null || user == null || password == null) {
			
			throw new SQLException("One or more database properties are missing.");
		}
		
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void main(String[] args) {
		
		try(Connection con = connect()) {
			
            System.out.println("Connected to the database successfully!");
        } catch (Exception ex) {
			
			ex.printStackTrace();
            System.out.println("Class Driver Tidak ditemukan");
        }
	}
}