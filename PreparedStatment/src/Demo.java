import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo {

	public static void main(String[] args) {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "admin");
			if(connection != null) {
				PreparedStatement statement = connection.prepareStatement("insert into user values(?,?,?,?)");
				statement.setString(1, "JOhn");
				statement.setString(2, "Ross");
				statement.setString(3, "JohnRoss");
				statement.setString(4, "John678");
				int executeUpdate = statement.executeUpdate();
				System.out.print(executeUpdate);
				statement.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
