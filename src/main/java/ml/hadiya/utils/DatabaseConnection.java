package ml.hadiya.utils;
import java.sql.Connection;
import java.sql.DriverManager;
// import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConnection
{
	private static String connectionString;

	public static Connection getConnection() {

		// Dotenv dotenv = Dotenv.load();

		// connectionString = dotenv.get("MYSQL_CONNECTION_STRING");
		// connectionString = System.getenv("MYSQL_CONNECTION_STRING");
		// connectionString = System.getProperty("mysql.connection.string");
		connectionString = "mysql://shoaib:Shoaib123@hadiya.local:3306/medistore";
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:"+connectionString);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return connection;
		
	}

}
