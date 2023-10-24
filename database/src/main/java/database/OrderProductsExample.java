package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OrderProductsExample {

	public static void main(String[] args) throws SQLException {
		String dburl = "jdbc:mysql://localhost:3306/classic_models";
		String user = "root";
		String password = "avelardo";

		Connection connection;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // optional

			connection = DriverManager.getConnection(dburl, user, password);

			Scanner sc = new Scanner(System.in);

			System.out.print("Enter order number: ");
			int orderNumber = sc.nextInt();

			String SelectSQL = "select p.id, p.product_name, od.quantity_ordered, "
					+ "p.msrp, p.buy_price, (p.msrp - p.buy_price) as margin "
					+ "from products p left join orderdetails od on p.id = od.product_id where od.order_id = ?";

			PreparedStatement stmt = connection.prepareStatement(SelectSQL);
			stmt.setInt(1, orderNumber);

			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				int id = result.getInt("p.id");
				String productName = result.getString("p.product_name");
				int quantityOrdered = result.getInt("od.quantity_ordered");
				double msrp = result.getDouble("p.msrp");
				double buyPrice = result.getDouble("p.buy_price");
				double margin = result.getDouble("margin");
				double totalMargin = margin * quantityOrdered;

				System.out.println(id + "	| " + productName + " | " + quantityOrdered + " | " + msrp + " | "
						+ buyPrice + " | " + margin + " | " + String.format("%.2f", totalMargin));
			}

			result.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
