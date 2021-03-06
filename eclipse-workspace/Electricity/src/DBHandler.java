
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHandler {
	public Connection establishConnection() {
		try {
			FileInputStream fileInputStream = new FileInputStream("./src/db.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);

			Class.forName(properties.getProperty("db.classname")); 

			return DriverManager.getConnection(
					properties.getProperty("db.url"),
					properties.getProperty("db.username"),
					properties.getProperty("db.password")
			);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}


