import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ModelLayer {
	private static Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    /**
     * 
     * @param user_name
     * @param user_pwd
     * @param db_name
     * @throws Exception
     */
	
    
    void connectDB(String user_name, String user_pwd, String db_name) throws Exception {
    	  // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
     //   connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback", "sqluser","sqluserpw");
        connect = DriverManager.getConnection("jdbc:mysql://localhost/"+db_name, user_name, user_pwd);

	}
    
    public static Connection getConnectionObj() {
    	return ModelLayer.connect;
    }

}