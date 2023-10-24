package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FirstConnection {
	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "avelardo";

		Connection connection;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional

			connection = DriverManager.getConnection(dburl, user, password);
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter an employee first name: ");
			String firstname = sc.nextLine();

			String SelectSQL = "SELECT * FROM employees WHERE firstname = '" + firstname + "' ";

			Statement stmt = connection.createStatement();
			ResultSet result = stmt.executeQuery(SelectSQL);

			while (result.next()) {
				int id = result.getInt("id");
				String name = result.getString("firstname");
				String email = result.getString("email");

				System.out.println(id + " | " + name + " | " + email);
			}

			result.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
