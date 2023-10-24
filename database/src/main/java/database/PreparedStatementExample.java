package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementExample {
	

	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "avelardo";

		Connection connection;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional

			connection = DriverManager.getConnection(dburl, user, password);

			Scanner sc = new Scanner(System.in);
			
			// Get first name from user
			System.out.print("Enter an employee first name: ");
			String firstname = sc.nextLine();

			// Get last name from user
			System.out.print("Enter an employee last name: ");
			String lastname = sc.nextLine();

			String SelectSQL = "SELECT * FROM employees WHERE firstname = ? AND lastname = ?";

			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setString(1, firstname);
			stmt.setString(2, lastname);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("id");
				firstname = result.getString("firstname");
				lastname = result.getString("lastname");
				String email = result.getString("email");

				System.out.println(id + " | " + firstname + " | " + lastname + " | " + email);
			}

			result.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
