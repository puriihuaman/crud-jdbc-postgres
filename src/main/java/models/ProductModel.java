package models;

import controllers.DatabaseConnection;

import java.sql.*;
import java.util.LinkedList;
import java.util.UUID;

public class ProductModel {
	public void createProduct(Product _product) {
		String query = "INSERT INTO product VALUES (?, ?, ?)";
		try (Connection conn = DatabaseConnection.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, _product.getProductName());
			ps.setDouble(2, _product.getPrice());
			ps.setShort(3, _product.getStock());
			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateProduct(Product _product) {
	}

	public void deleteProduct(UUID _productId) {
	}

	public Product getProduct(UUID _productId) {
		return null;
	}

	public ResultSet getAllProducts() {
		ResultSet rs = null;
		String query = "SELECT product_id, product_name, price, stock FROM product";
		try (Connection conn = DatabaseConnection.getConnection()) {
			Statement stmt = conn.createStatement();

			rs = stmt.executeQuery(query);
			// rs = stmt.getResultSet();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return rs;
	}


}
